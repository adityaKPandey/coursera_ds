public class HelloGoodbye {

  public static void main(String [] args){

     StringBuilder stringBuilder = new StringBuilder();
     System.out.println(stringBuilder.append("Hello ").append(args[0]).append(" and ").append(args[1]).append(".").toString());

     stringBuilder = new StringBuilder();
     System.out.println(stringBuilder.append("Goodbye ").append(args[1]).append(" and ").append(args[0]).append(".").toString());

  }

}
