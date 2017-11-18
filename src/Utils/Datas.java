package Utils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Chris on 09/09/2015.
 */
public class Datas {
    public static String[] diasDaSemana = new DateFormatSymbols().getWeekdays();

    public static Date HHmmToDate(String data){
        Date date;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            date = sdf.parse(data);

        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }
        return date;
    }

    public static String DateToHHmm(Date data){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return sdf.format(data);

        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }
    }

    public static Date DateToTime(Date date){
        SimpleDateFormat pessego = new SimpleDateFormat("HH:mm:ss");
        Date retorno = null;
        try {
            retorno = pessego.parse(pessego.format(date));
        } catch (ParseException e) {
            return null;
        }
        return retorno;
    }
    public static Date Agora(){
        Date date = new Date();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            date = sdf.parse(DateToHHmm(date));

        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }
        return date   ;
    }
    public static Date ddMMyyyyToDate(String data){
        Date date;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            date = sdf.parse(data);

        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }
        return date;
    }

    public static String DateToddMMyyyy(Date data){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(data);
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }
    }

    public static String DateToyyyyMMdd(Date data){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(data);
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }
    }

    public static Date yyyyMMddToDate(String data){
        Date date;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(data);

        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }
        return date;
    }
    public static String diaSemana(Date data){
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return diasDaSemana[day-1];
    }

    public static Boolean between(Date date, Date dateStart, Date dateEnd) {
        return date.compareTo(dateStart)>= 0 && date.compareTo(dateEnd) <=0;
    }

    public static Integer diferencaEmMinutos(Date date1, Date date2){
        long diferenca  = Datas.DateToTime(date1).getTime() - Datas.DateToTime(date2).getTime();
        return (int) (diferenca / 1000L)/60;
    }
    public static Integer SEGUNDA = 1;
    public static Integer TERCA = 2;
    public static Integer QUARTA = 3;
    public static Integer QUINTA = 4;
    public static Integer SEXTA = 5;
    public static Integer SABADO = 6;
    public static Integer DOMINGO = 0;


    public static Integer hoje(){
       return Datas.getDiaDaSemana(new Date());
    }

        /*Retorna o valor inteiro referente ao dia da semana */
    public static Integer getDiaDaSemana(Date data){
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return day - 1; //Pois o DAY_OF_WEEK começa em 1
    }
}
