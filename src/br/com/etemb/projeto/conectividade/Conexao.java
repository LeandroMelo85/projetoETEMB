package br.com.etemb.projeto.conectividade;

/**
 *
 * @author Leandro Melo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.etemb.projeto.meusclientes.Clientes;

public class Conexao {
	
		private final String fonte = "jdbc:mysql://teste_padrao.mysql.dbaas.com.br/teste_padrao";
		private final String driver = "com.mysql.jdbc.Driver";
		private final String usuario = "teste_padrao";
		private final String senha = "Pad4011@sa";
		private Connection con;
		private PreparedStatement stm;
		
	public void CadastrarCliente(Clientes clientes) throws SQLException{
		this.con = DriverManager.getConnection(fonte, this.usuario, this.senha);
		this.stm = this.con.prepareStatement("INSERT INTO CLIENTES VALUES (?, ?, ?, ?, ?)");
		
                this.stm.setInt(1, clientes.getId());
		this.stm.setString(2, clientes.getNome());
		this.stm.setString(3, clientes.getTelefone());
		this.stm.setString(4, clientes.getCelular());
		this.stm.setString(5, clientes.getEmail());
		
		this.stm.execute();
		this.stm.close();
	}
		
	public Clientes ProcurarCliente(int id) throws SQLException {
		this.con = DriverManager.getConnection(fonte, this.usuario, this.senha);
		this.stm = this.con.prepareStatement("SELECT * FROM CLIENTES WHERE ID = ?");
		this.stm.setInt(1, id);
		ResultSet rs = this.stm.executeQuery();
		
		Clientes clientes = new Clientes();
			while(rs.next()) {
				clientes.setId(rs.getInt("ID"));
				clientes.setNome(rs.getString("NOME"));
				clientes.setTelefone(rs.getString("TELEFONE"));
				clientes.setCelular(rs.getString("CELULAR"));
				clientes.setEmail(rs.getString("EMAIL"));
			}
			
		this.con.close();
		return clientes;
	}
	public void AtualizarCliente(Clientes clientes, int id) throws SQLException {
		this.con = DriverManager.getConnection(fonte, this.usuario, this.senha);
		this.stm = this.con.prepareStatement("UPDATE CLIENTES SET NOME = ?, TELEFONE = ?, CELULAR = ?, EMAIL = ? WHERE ID = ?");
		
		this.stm.setString(1, clientes.getNome());
		this.stm.setString(2, clientes.getTelefone());
		this.stm.setString(3, clientes.getCelular());
		this.stm.setString(4, clientes.getEmail());
		this.stm.setInt(5, id);
		
		this.stm.executeUpdate();
		this.con.close();
	}
	public void RemoverCliente(int id) throws SQLException {
		this.con = DriverManager.getConnection(fonte, this.usuario, this.senha);
		this.stm = this.con.prepareStatement("DELETE FROM CLIENTES WHERE ID = ?");
		this.stm.setInt(1, id);
		this.stm.execute();
		this.con.close();
		}
}