package Connection;

import java.sql.*;

public class TesteConexao {
  public static void main(String args[]){
	Connection conexao = new TesteConexaoMysql().conexaoMysql();
	if (conexao != null) System.out.println("Conexao efetuada com sucesso!");
	else				System.out.println("Houve um erro na conexão!");
  }
}