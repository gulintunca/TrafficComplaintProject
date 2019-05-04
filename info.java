package utils;

public class info {
      int id;
      String name,surname,nick,pass;
      public info(int id,String name,String surname,String nick,String pass){
          this.id=id;
          this.name=name;
          this.surname=surname;
          this.nick=nick;
          this.pass=pass;
      }
      public int getid(){
          return id;
      }
      public String getname(){
          return name;
      }
      public String getsurname(){
          return surname;
      }
      public String getnick(){
          return nick;
      }
      public String getpass(){
          return pass;
      }
}
