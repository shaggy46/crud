package firstcrud.demo.dao;

import firstcrud.demo.beans.Clients;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class ClientsDao {
JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int addAll(Clients p){
        String sql ="UPDATE clients(first_name,last_name,email,item_id) values('"+p.getFirst_name()+",'"+p.getLast_name()+",'"+p.getEmail()+",'"+p.getId()+"')";
        return template.update(sql);
    }
    public int addProduct(Clients p){
        String sql ="UPDATE clients(item_id) VALUES ('"+p.getId()+"')";
        return template.update(sql);
    }
    public int deleteAll(int id){
        String sql ="DELETE FROM clients WHERE id="+id+"";
        return template.update(sql);
    }
    public int deleteProduct(Clients p){
        String sql = "";
        return template.update(sql);
    }
    public int update(Clients p){
        String sql="update clients SET first_name='"+p.getFirst_name()+"', last_name="+p.getLast_name()+",email='"+p.getEmail()+"',item_id="+p.getItem_id()+" where id="+p.getId()+"";
        return template.update(sql);
    }

    public Clients getClientById(int id){
        String sql="select * from clients where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Clients>(Clients.class));
    }
    public List<Clients> getClients(){
         final String sql = "SELECT * FROM clients";
         List<Clients> clients = template.query(sql, new RowMapper<Clients>(){
             public Clients mapRow(ResultSet resultSet,int i) throws SQLException{
                 Clients client = new Clients();
                 client.setId(resultSet.getInt("id"));
                 client.setFirst_name(resultSet.getString("first_name"));
                 client.setLast_name(resultSet.getString("last_name"));
                 client.setEmail(resultSet.getString("email"));
                 client.setItem_id(resultSet.getInt("item_id"));
                 return client;
                 }
                 }

         );
         return clients;
    }
}
