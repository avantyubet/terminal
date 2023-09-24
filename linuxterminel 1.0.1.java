import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        //默认host：linuxterm
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


        File fileq = new File("rootpasswd");

        //判断是否有密码文件
        if (!fileq.exists()){
           fileq.createNewFile();
            BufferedWriter newrootpwd = new BufferedWriter(new FileWriter("rootpasswd"));
            //默认密码：114514
            newrootpwd.write("114514");
            newrootpwd.close();

        }

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
        System.out.println("welcome to myterminal!");
        System.out.println("use 'help' see command" );
        while(true){
            //命令头显示
            Scanner usr = new Scanner(System.in);
            if (login.equals("root")) {
                System.out.print("[" + "root" +"@" + "linuxterm " + woksfiles + "] ");//可自定义

            System.out.print("zsh -- #");
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
                System.out.println("allcommand:    ");
                System.out.println("pwd       当前工作目录显示     ");
                System.out.println("rm       删除文件       ");
                System.out.println("whoami      显示当前使用者");
                System.out.println("time        当前时间");
                System.out.println("code        显示编译器和作者");
                System.out.println("cd         切换工作目录");
                System.out.println("su         切换使用者");
                System.out.println("touch        创建文件");
                System.out.println("vim       写入文件");
                System.out.println("sum        求和");
                System.out.println("passwd      更换root密码");
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
            } else if (dir.equals("exit") || dir.equals("shutdown")) {
                System.out.println("see you next time " + login + "!");
                break;
            }

            else if (dir.equals("time")){
                double time = System.currentTimeMillis();
                System.out.println(time);
            }
            //显示语言
            else if (dir.equals("code")){
                System.out.println("This is a java app , A low linux terminal");
                System.out.println("|||   |||   ||||||||||   ||   ||    |||    |||");
                System.out.println("|||         |||    |||   ||   ||     |||  ||| ");
                System.out.println("|||   |||   |||    |||   ||   ||      ||||||  ");
                System.out.println("|||   |||   |||    |||   ||   ||     |||  ||| ");
                System.out.println("||||| |||   |||    |||    |||||     |||    |||");
            }
            //切换工作目录
            else if (dir.equals("cd")){

                System.out.print("cd the file:");


                woksfiles = new Scanner(System.in).next();

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
                String playinput = fileinput.nextLine();
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



            else if (dir.equals("mkdir")){
                System.out.print("Dir name:");
                String Mkdir = new Scanner(System.in).nextLine();
                File mkdir1 = new File(Mkdir);
                mkdir1.mkdir();
                System.out.println("New dir complete!");
            }

            else if (dir.equals("passwd")){
                System.out.print("The new root password");
                String password = new Scanner(System.in).nextLine();
                BufferedWriter rot = new BufferedWriter(new FileWriter("rootpasswd"));
                rot.write(password);
                rot.close();
            }
            //copy 命令
            else if (dir.equals("cp")){
                System.out.print("The copy File name:");
                String cp = new Scanner(System.in).nextLine();
                BufferedWriter out2 = new BufferedWriter(new FileWriter(cp + "-copyfile"));
               BufferedReader out3 = new BufferedReader(new FileReader(cp));
               String arm = out3.readLine();
               out2.write(arm);
               out2.close();

            }

            else if (dir.equals("neofetch")){
                System.out.println("|||   |||   ||||||||||   ||   ||    |||    |||");
                System.out.println("|||         |||    |||   ||   ||     |||  ||| ");
                System.out.println("|||   |||   |||    |||   ||   ||      ||||||  ");
                System.out.println("|||   |||   |||    |||   ||   ||     |||  ||| ");
                System.out.println("||||| |||   |||    |||    |||||     |||    |||");
                System.out.println("system:linux"  + "     Terminel:MYterminel" + "     kernel:5.1.3.10");
            }

            else
            {
                System.out.println("error command");
            }
        }
    }



}
