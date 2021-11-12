import java.util.Scanner;

class Kiosk{
    static int total_price;
    static int cash, change;
    static String success_msg = "결제가 완료 되었습니다.";
    static int stage = 1;
    
    static Menu[] menus = new Menu[4];
    static Menu selected_menu;

    public static void main(String[] args){ 
        Scanner my_scanner = new Scanner(System.in);

        menus[0] = new Menu("아이스아메리카노", 3000);
        menus[1] = new Menu("카라멜마끼아또", 4000);
        menus[2] = new Menu("카페모카", 4000);
        menus[3] = new Menu("베이글", 3500);

        while(true){
            if(stage == 1){
                System.out.println("\n\n어서오세요. KHAJ Cafe입니다.");
                for(int i = 0; i < menus.length; i++){
                    System.out.println((i+1)+". "+menus[i].name+" "+menus[i].price+"원");
                }
    
                System.out.print("메뉴 번호를 입력해주세요 : ");
                String selected_menu_number = my_scanner.nextLine();
                select(selected_menu_number);
            }
            else if(stage == 2){
                System.out.println("\n선택하신 메뉴 "+selected_menu.name+" 가격은 "+selected_menu.price+"원 입니다.");

                System.out.print("현금을 입력해주세요 : ");
                cash = Integer.parseInt(my_scanner.nextLine());
                change = pay();
    
                if(change == -1){
                    System.out.println("돈이 맞지 않습니다.");
                }
                else{
                    System.out.println(success_msg);
                    System.out.println("거스름돈은 "+change+"원 입니다.");
                    stage++;
                }
            }
            else{
                stage = 1;
                selected_menu = null;
                cash = 0;
                change = 0;
            }
        }
    }

    public static void select(String menu_number){ 
        switch(menu_number){
                case "1":
                    selected_menu = menus[0];
                break;

                case "2":
                    selected_menu = menus[1];
                break;

                case "3":
                    selected_menu = menus[2];
                break;

                case "4":
                    selected_menu = menus[3];
                break;

                default:
                    selected_menu = null;
                break;
            }

            if(selected_menu == null){
                System.out.println("\n그런 메뉴 번호는 없습니다."); 
            }
            else{
                System.out.println("\n"+selected_menu.name+"를 선택하셨습니다.");
                stage++;
            }
    }

    public static int pay(){
        if(cash >= selected_menu.price){
            return cash - selected_menu.price;
        }
        else{
            return -1;
        }
    }
}