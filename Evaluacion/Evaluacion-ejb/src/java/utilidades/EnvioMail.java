/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Named
public class EnvioMail {

    public static void enviaMail(String to, String html) {
         try {
            Properties props = new Properties();
//            props.put("mail.smtp.host", "smtp.gmail.com");
//            props.put("mail.smtp.socketFactory.port", "465");
//            props.put("mail.smtp.socketFactory.class",
//                    "javax.net.ssl.SSLSocketFactory");
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.host", "s412b.panelboxmanager.com");
//            props.put("mail.smtp.socketFactory.port", "465");
//            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//            props.put("mail.smtp.auth", "false");
//            props.put("mail.smtp.port", "25");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("encuestas@prolipa.com.ec", "Productora2016");
                        }
                    }
            );
//            
            MimeMessage msg = new MimeMessage(session);

            if (to.contains(";")) {
                String[] emails = to.split(";");
                Address[] addresses = new Address[emails.length];
                for (int i = 0; i < emails.length; i++) {
                    addresses[i] = new InternetAddress(emails[i]);
                }
                msg.addRecipients(Message.RecipientType.TO, (Address[]) addresses);
            } else {
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            }
            
            msg.setFrom(new InternetAddress("encuestas@prolipa.com.ec" ));
            msg.setSubject("Sistema de test");
            msg.setSentDate(new Date());
            msg.setContent(html,"text/html; charset=utf-8");
            Transport.send(msg);
        } catch (NoSuchProviderException ex) {
            System.out.println(ex.toString());
            //Logger.getLogger(MostrarMensaje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            System.out.println(ex.toString());
            //Logger.getLogger(MostrarMensaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
