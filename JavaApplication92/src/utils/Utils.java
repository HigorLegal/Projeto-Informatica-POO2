package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Utils {

  

    public static String calcularHash(String senha) {
        String hashSHA1 = "";
        try {

            //crie uma instancia do messageDigest com o algoritimo SHAI que vai calcular o hash do sha1
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");

            //  coloca os bytes da senha no digest calculando o hash da senha
            sha1.update(senha.getBytes());

            //cria um Arraylist que vai conter o hash da senha
            byte[] digest = sha1.digest();

            //vai ser usado para converte o hash da senha de bytes para uma representaçao  hexadecimal e juntar ela
            StringBuilder sb = new StringBuilder();

            //loop para converter a lista byte 
            for (byte b : digest) {

                //seta o formato e converte os bytes da senha para hexadecimal
                sb.append(String.format("%02x", b));
            }

            hashSHA1 = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.err.println("algoritimo SHAI nao encontrado");
        }
        return hashSHA1;
    }

    public static Icon ConverterFileParaIcon(File file) {
        //pega o file que e uma imagem e coloca em uma variavel que e do tipo icon
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());

        return icon;
    }

    public static ImageIcon RedirecionarIcon(Icon imgOriginal, int altura, int largura) {
        //pega o icon e transforma em image
        Image img = ((ImageIcon) imgOriginal).getImage();

        //redimenciona a imagem original para o tamanho informado 
        Image imgRed = img.getScaledInstance(altura, altura, Image.SCALE_SMOOTH);

        //retorna a imagem redirecionada como ImageIcon
        return new ImageIcon(imgRed);
    }

    public static byte[] converterImagenToBytes(Icon icon) {

        BufferedImage img = new BufferedImage(
                icon.getIconHeight(),
                icon.getIconWidth(),
                BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g2d = img.createGraphics();

        icon.paintIcon(null, g2d, 0, 0);

        g2d.dispose();

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        try {

            ImageIO.write(img, "png", byteArray);

        } catch (IOException erro) {

            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, erro);
        }

        return byteArray.toByteArray();
    }

}
