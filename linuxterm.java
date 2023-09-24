import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{

        Scanner user = new Scanner(System.in);
        System.out.print("login user's name:");
        String  login = user.next();
        BufferedReader bir1 = new BufferedReader(new FileReader("rootpasswd"));
        String root = "";
        root = bir1.readLine();
        //默认工作目录
        String woksfiles = "~";
        if (login.equals("root")) {
            System.out.print("The root passwd");
            String passwd = new Scanner(System.in).nextLine();
            if (passwd.equals(root)){
                System.out.println("welcome root!");
            }
            else {
                System.out.println("passwd error");
                login = "user";
            }
        }
        System.out.println("welcome to myterm!");
        System.out.println("use 'help' see command" );
        while(true){
            //命令头显示
            Scanner usr = new Scanner(System.in);
            if (login.equals("root")) {

                System.out.print(login + "@linuxterm " + woksfiles + " #");
            }
            else {
                System.out.print(woksfiles + " $");
            }
                String dir = usr.next();

            //检测并判断是否输入命令
            if (dir.equals("pwd")){
                System.out.println(woksfiles);
            }

            else if(dir.equals("help")){
                System.out.println("allcommand:    " +
                        "pwd      当前工作目录显示         " +
                        "rm       删除文件       " +
                        "whoami      当前使用用户             " +
                        "time     当前时间戳         " +
                        "code      显示作者与编译器          " +
                        "cd        切换工作目录           " +
                        "touch     创造文件           " +
                        "vim        编辑文件          " +
                        "su " +
                        "cat        读取文件内容             " +
                        "sum          求和      " +
                        "exit         退出终端         " +
                        "passwd        更改root密码       ");
            }
            //删除命令
            else if (dir.equals("rm")) {


                System.out.print("remove the file:");
                String name = new Scanner(System.in).next();


                System.out.print("Are you sure? [y n]");
                String sure = new Scanner(System.in).next();
                if (sure.equals("y")) {
                    File filerm = new File(name);


                    if (filerm.delete()) {
                        System.out.println("delete complete!");
                    } else {
                        System.out.println("delete error!");
                    }
                }

                        else {
                            System.out.println("exit remove");
                        }


                }
            //显示使用者
            else if (dir.equals("whoami")){
                System.out.println("You are " + login);
            } else if (dir.equals("exit")) {
                System.out.println("see you next time " + login + "!");
                break;
            }

            else if (dir.equals("time")){
                double time = System.currentTimeMillis();
                System.out.println(time);
            }
            //显示语言
            else if (dir.equals("code")){
                System.out.println("This is a java app , A low linux term ， 作者:大乙猫");
                System.out.println("|||   |||   ||||||||||   ||   ||    |||    |||");
                System.out.println("|||         |||    |||   ||   ||     |||  ||| ");
                System.out.println("|||   |||   |||    |||   ||   ||      ||||||  ");
                System.out.println("|||   |||   |||    |||   ||   ||     |||  ||| ");
                System.out.println("||||| |||   |||    |||    |||||     |||    |||");
            }
            //切换工作目录
            else if (dir.equals("cd")){

                System.out.print("cd the file:");
                String namework = new Scanner(System.in).next();

                woksfiles = namework;

            }

            else if (dir.equals("su")){
                System.out.print("The new user name:");
                Scanner username = new Scanner(System.in);
                String zhengusername = username.nextLine();
                if (zhengusername.equals("root")) {
                    System.out.print("The root passwd");
                    String passwd2 = new Scanner(System.in).nextLine();
                    if (passwd2.equals(root)){
                        System.out.println("welcome root!");
                        login = zhengusername;
                    }
                    else {
                        System.out.println("passwd error");
                        login = "user";
                    }
                }
                else {
                    login = zhengusername;
                }
            }

            else if (dir.equals("touch")){
                System.out.print("The File Name:");
                Scanner filen = new Scanner(System.in);
                String filena = filen.nextLine();
                File file = new File(filena);
                System.out.println("new file complete!");
                file.createNewFile();
            }

            else if (dir.equals("vim")) {
                System.out.print("Input the file name:");

                String filena_ = new Scanner(System.in).nextLine();
                //指定文件名并执行写入
                BufferedWriter out = new BufferedWriter(new FileWriter(filena_));
                System.out.print("Input the text:");
                Scanner fileinput = new Scanner(System.in);
                String playinput = fileinput.next();
                out.write(playinput);
                //关闭并保存文件
                out.close();

            } else if (dir.equals("cat")) {
                System.out.print("The cat file name:");
                Scanner catname = new Scanner(System.in);
                String cat = catname.nextLine();

                BufferedReader bir = new BufferedReader(new FileReader(cat));
                String str = "";

                while ((str = bir.readLine()) != null){
                    System.out.println(str);
                }
            }

            else if (dir.equals("sum")){
                System.out.print("num1:");
                int nu1 = new Scanner(System.in).nextInt();
                System.out.print("num2:");
                int nu2 = new Scanner(System.in).nextInt();
                System.out.println(nu1 + nu2);

            }

            else if (dir.equals("passwd")){
                System.out.print("The new root password");
                String pasword = new Scanner(System.in).nextLine();
                BufferedWriter rot = new BufferedWriter(new FileWriter("rootpasswd"));
                rot.write(pasword);
                rot.close();
            }

            else
            {
                System.out.println("error command");
            }
        }
    }



}