package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Abstrac.DAO;
import Modelo.Cliente;
import Modelo.Departamento;
import Modelo.Distrito;
import Modelo.Provincia;

public class ClienteDAO extends DAO<Cliente> {

    public List<Cliente> obtenerTodos() {
        String sql = "EXEC SP_ObtenerClientes"; // Ajusta según tu procedimiento almacenado
        List<Cliente> listaClientes = new ArrayList<>();

        try (Connection con = getconection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = parsear(rs);
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    public boolean guardarCliente(Cliente cliente) {
        String sql = "EXEC SP_GuardarCliente ?,?,?,?,?,?"; // Solo 7 parámetros
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, cliente.getNombre());
            cs.setString(2, cliente.getTipoDocumento());
            cs.setString(3, cliente.getNumeroDocumento());
            cs.setInt(4, cliente.getDistrito().getId()); // Solo distrito_id
            cs.setString(5, cliente.getTelefono());
            cs.setString(6, cliente.getEmail());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cliente parsear(ResultSet rs) {
        try {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setTipoDocumento(rs.getString("tipo_documento"));
            cliente.setNumeroDocumento(rs.getString("numero_documento"));

            // Carga las relaciones
            Departamento departamento = new Departamento();
            departamento.setId(rs.getInt("departamento_id"));
            departamento.setNombre(rs.getString("nombre_departamento"));
            cliente.setDepartamento(departamento);

            Provincia provincia = new Provincia();
            provincia.setId(rs.getInt("provincia_id"));
            provincia.setNombre(rs.getString("nombre_provincia"));
            cliente.setProvincia(provincia);

            Distrito distrito = new Distrito();
            distrito.setId(rs.getInt("distrito_id"));
            distrito.setNombre(rs.getString("nombre_distrito"));
            cliente.setDistrito(distrito);

            cliente.setTelefono(rs.getString("telefono"));
            cliente.setEmail(rs.getString("email"));
            return cliente;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
