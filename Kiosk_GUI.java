import javax.swing.*;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JButton;
import java.awt.event.*;
import java.awt.*;
//import java.awt.CardLayout;
//import java.awt.FlowLayout;

class Kiosk_GUI extends JFrame{

    CardLayout card_layout;
    Menu[] menus = new Menu[4];

    public Kiosk_GUI(String title){
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        menus[0] = new Menu("뜨아");
        menus[1] = new Menu("아아", 3000);
        menus[2] = new Beverage("레몬에이드", 3500, true);
        menus[3] = new Coffee("콜드브루", 4000, false, "브라질");

        card_layout = new CardLayout();

        setLayout(card_layout);

        JPanel menu_view = new JPanel();
        add(menu_view, "menu_view");

        menu_view.setLayout(new FlowLayout());

        // for(int i = 0; i < menus.length; i++){
        //     JButton btn = new JButton(menus[i].name+" "+menus[i].price);
        //     menu_view.add(btn);
        // }
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(e.getActionCommand());
            }
        };

        for(Menu menu : menus){
            JButton btn = new JButton(menu.name+" "+menu.price+"원");
            menu_view.add(btn);
            btn.setActionCommand(menu.name);
            btn.addActionListener(al);
        }
    }

    public static void main(String[] args){
        
        Kiosk_GUI kiosk_frame = new Kiosk_GUI("KHAJ Kiosk");
        kiosk_frame.setSize(400, 500);
        kiosk_frame.setVisible(true);
        //Kiosk_GUI kiosk_btn1 = new Kiosk_GUI("shangus");
        // kiosk_btn1.setBounds(30, 30, 150, 150);
        // kiosk_frame.getContentPane().add(kiosk_btn1);
    }
}