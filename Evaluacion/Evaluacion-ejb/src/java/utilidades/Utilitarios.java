/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.Calendar;

/**
 *
 * @author Multimedia
 */
public class Utilitarios {

    public static String generarNumeroTest() {
        Calendar Calendario = Calendar.getInstance();
        String numeroEvento;
        String anio;
        String mes;
        String dia;
        String hora;
        String minuto;
        String segundo;

        anio = Integer.toString(Calendario.get(Calendar.YEAR));

        mes = Integer.toString(Calendario.get(Calendar.MONTH) + 1);
        if (mes.length() < 2) {
            mes = "0" + mes;
        }
        dia = Integer.toString(Calendario.get(Calendar.DATE));
        if (dia.length() < 2) {
            dia = "0" + dia;
        }

        numeroEvento = dia + mes + anio;
        //System.out.println("Año: " + año + "\nMes: " + mes + "\nDia: " + dia + "\nHora: " + hora + "\nMinuto: " + minuto + "\nSegundo: " + segundo + "\nRandom: " + (r.nextInt(8) + 1));
        return numeroEvento;
    }

    public static String emailPsico(String psico, String codigo) {
        String html;
        html = "  <!doctype html> "
                + "  <html> "
                + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> "
                + "               <body style=\"width: 550px;height: 80px;\"> "
                + "               <table  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse\"> "
                + "                    <tr id=\"1\"> "
                + "                      <td bgcolor=\"#fff\" style=\"padding: 0px 0 10px 0;\" >"
                + "                          <b>Comunicado</b> "
                + "                      </td> "
                + "                    </tr> "
                + "                    <tr id=\"2\"> "
                + "                      <td bgcolor=\"#fff\" style=\"padding: 0px 0 10px 0;\" > "
                + "                          <span>Estimado(a):"+psico+" </span> "
                + "                      </td> "
                + "                    </tr> "
                + "                    <tr id=\"2\"> "
                + "                      <td bgcolor=\"#fff\" style=\"padding: 0px 0 10px 0;\" > "
                + "                          <span>Se ha ingresado un test con codigo "+codigo+" en el sistema.</span> "
                + "                      </td> "
                + "                    </tr> "
                + "                    <tr id=\"3\"> "
                + "                      <td bgcolor=\"#fff\" style=\"padding: 0px 0 10px 0;\" > "
                + "                          <a href="+"http://10.10.18.197:8080/Evaluacion-war"+">Sistema Evaluacion</a> "
                + "                      </td> "
                + "                    </tr> "
                + "                    <tr id=\"4\"> "
                + "                      <td bgcolor=\"#fff\" style=\"padding: 0px 0 10px 0;\" > "
                + "                          <strong>Sistema de Evaluaciones</strong> "
                + "                          </br> "
                + "                          <span>Mensaje generado automaticamente</span> "
                + "                      </td> "
                + "                    </tr> "
                + "               </table> "
                + "          </body> "
                + "   </html> ";

        return html;
    }
}
