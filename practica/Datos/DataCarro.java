package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Carro;

public class DataCarro {
    List<Carro> lis = new ArrayList<Carro>();
    int id = 0;
    

    public List<Carro> list(String filter) {
        List<Carro> lis2 = new ArrayList<Carro>();
        String sql = "SELECT * FROM carro ";
        try {
            Statement st = BaseDatos.connectSQLite().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Carro p = new Carro();
                p.setId(rs.getInt("id"));
                p.setMarca(rs.getString("Marca"));
                p.setColor(rs.getString("color"));
                p.setAge(rs.getInt("age"));
                lis2.add(p);                
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return lis2;
    }

    public void create(Carro d) {
        String sql = "INSERT INTO carro(marca, color, age) "
                + " VALUES(?,?,?) ";
        int i = 0;
        int res =0;
        try {
            PreparedStatement ps = BaseDatos.connectSQLite().prepareStatement(sql);
            ps.setString(++i, d.getMarca());
            ps.setString(++i, d.getColor());
            ps.setInt(++i, d.getAge());
            res = ps.executeUpdate();// 0 no o 1 si commit
            System.out.println("create.res=" + res);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM carro WHERE id = ?";
        int res =0;
        try {
            PreparedStatement ps = BaseDatos.connectSQLite().prepareStatement(sql);
            ps.setInt(1, id );
            res = ps.executeUpdate();
            System.out.println("delete.res=" + res);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public Carro get(int id) {
        Carro p =new Carro();
        String sql = "SELECT * FROM carro WHERE id = "+id+" ";
        try {
            Statement st = BaseDatos.connectSQLite().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setMarca(rs.getString("marca"));
                p.setColor(rs.getString("color"));
                p.setAge(rs.getInt("age"));               
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return p;
    }
    
    public void update(Carro d) {
        String sql = "UPDATE carro SET "
                + "marca=?, "
                + "color=?, "
                + "age=? "
                + "WHERE id=?";
        int i = 0;
        int res =0;
        try {
            PreparedStatement ps = BaseDatos.connectSQLite().prepareStatement(sql);
            ps.setString(++i, d.getMarca());
            ps.setString(++i, d.getColor());
            ps.setInt(++i, d.getAge());
            ps.setInt(++i, d.getId());
            res = ps.executeUpdate();// 0 no o 1 si commit
            System.out.println("update.res=" + res);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return ;
    }
}
