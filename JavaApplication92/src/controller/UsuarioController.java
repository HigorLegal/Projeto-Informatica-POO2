/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import model.Usuario;


import utils.Utils;

/**
 *
 * @author s.lucas
 */
public class UsuarioController {

    public boolean autenticar(String email, String senha) {
        String sql = "SELECT * from TBUSUARIO "
                + "WHERE email = ? and senha = ? ";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, email);
            comando.setString(2, senha);

            resultado = comando.executeQuery();
//se passar para a proxima linha ou seja achar um usuario ele retorna true
            if (resultado.next()) {
                return true;
            }

        } catch (SQLException e) {
            //mostra o erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            //fecha conxao
            gerenciador.fecharConexao(comando, resultado);
        }
        return false;
    }

    public boolean criarUsuario(Usuario usu) {
        //comando do sql
        String Sql = "insert into tbusuario (nome,email,senha,ativo,image)value(?,?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            //usa o metodo para converter a imagem para bytes e coloca na variavel do tipo bytes iconBytes
            byte[] iconBytes = Utils.converterImagenToBytes(usu.getImage());

            //prepara a String sql e tranforma em um pra o uso, tambem é usado para alterar  o comando quando ha variaveis
            comando = gerenciador.prepararComando(Sql);

            //aqui esta sendo colocado cada atributo em cada variavel os "?" 1,2,3,4...                                    
            comando.setString(1, usu.getNome());
            comando.setString(2, usu.getEmail());
            comando.setString(3, usu.getSenha());
            comando.setBoolean(4, usu.isAtivo());
            comando.setBytes(5, iconBytes);

            //vai executar o comando sql
            comando.executeUpdate();
            return true;

        } catch (SQLException e) {
//mostra o erro
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        } finally {
//fecha a conexao 
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
//lista todos os usuarios da DataBase

    public Usuario buscaPk(int id) {
        String sql = "SELECT pkusuario, nome, email, senha, ativo , image from tbusuario where pkusuario = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        Usuario usu = new Usuario();
        try {
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, id);
            resultado = comando.executeQuery();
            if (resultado.next()) {

                usu.setPkusuario(resultado.getInt("pkusuario"));
                usu.setNome(resultado.getString("nome"));
                usu.setEmail(resultado.getString("email"));
                usu.setSenha(resultado.getString("senha"));
                usu.setAtivo(resultado.getBoolean("ativo"));

                byte[] bytes = resultado.getBytes("image");
                if (bytes != null) {
                    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

                    BufferedImage image = ImageIO.read(bis);

                    usu.setImage(new ImageIcon(image));
                }
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            gerenciador.fecharConexao(comando, resultado);
        }
        return usu;
    }

    public Usuario buscaEmail(String email) {
        String sql = "SELECT pkusuario, nome, email, senha, ativo , image from tbusuario where email = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        Usuario usu = new Usuario();
        try {
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, email);
            resultado = comando.executeQuery();
            if (resultado.next()) {

                usu.setPkusuario(resultado.getInt("pkusuario"));
                usu.setNome(resultado.getString("nome"));
                usu.setEmail(resultado.getString("email"));
                usu.setSenha(resultado.getString("senha"));
                
                usu.setAtivo(resultado.getBoolean("ativo"));

                byte[] bytes = resultado.getBytes("image");
                if (bytes != null) {
                    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

                    BufferedImage image = ImageIO.read(bis);

                    usu.setImage(new ImageIcon(image));
                }

            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            gerenciador.fecharConexao(comando, resultado);
        }
        return usu;
    };
}
