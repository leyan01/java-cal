package cal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Cal {
    
    StringBuffer sb = new StringBuffer();
    boolean flag = false;
    
    double num1=0;
    double num2=0;
    boolean equals = false;
    String a = "";
    JFrame f;
    JTextField t;
    double temp=0;
    Font font = new Font(Font.DIALOG, Font.BOLD,25);
     void btn(int x, int y, int width, int height, JButton button, int num) {
        button.setBounds(x,y,width,height);
        button.setBackground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFont(font);
        if(num==10||num==11||num==12||num==13||num==20||num==25){
            if(num==10||num==11||num==12||num==13){
                
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        
                        temp = num1;
                        num1 = Double.parseDouble(t.getText());
                        sb.delete(0, sb.length());
                        String s= sb.toString();
                        t.setText(s);
                        if(a.equals("+")) {
                            num1 = temp+ num1;
                        }
                        else if(a.equals("-")){
                            num1 = temp-num1;
                        }
                        else if(a.equals("*")){
                            num1 = temp*num1;
                        }
                        else if(a.equals("/")){
                            num1 = temp/num1;
                        }
                        a = button.getLabel();
                       
                        
                    }
                });
            }
            else if(num==25){
                button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {                            
                            num1=0;
                            num2=0;
                            sb.delete(0, sb.length());
                            String s = sb.toString();
                            t.setText(s);
                        }
                });
                
            }
            else{
              
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {                            
                            num2 = Double.parseDouble(t.getText());
                            switch(a){
                                case "+":
                                    num1 += num2;
                                    break;
                                case "-":
                                    num1 -= num2;
                                    break;
                                case "x":
                                    num1 *= num2;
                                    break;
                                case "/":
                                    num1 /= num2;
                                    break;
                                    
                            }
                            sb.delete(0, sb.length());
                            sb.append(num1);
                            String s = sb.toString();
                            t.setText(s);
                            equals = true;
                        }
                });
                }
            
        }else{
              
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.out.println("sb:"+sb);
                    System.out.println("t: "+t.getText());
                   
                    if(equals==true){
                        num1 = 0;
                        num2 = 0;
                        sb.delete(0, sb.length());
                        t.setText("");
                        equals =false;
                    }

                   if(num==0){
                       if("0".equals(t.getText())){

                       }else{
                           sb.append(button.getLabel());
                           String s= sb.toString();
                           t.setText(s);
                       }

                   }else if(num==15){
                       if("".equals(t.getText())){
                           sb.append("0");
                           sb.append(button.getLabel());
                           String s= sb.toString();
                           t.setText(s);
                       }else{
                           if(t.getText().contains(".")){}
                           else{
                               sb.append(button.getLabel());
                               String s= sb.toString();
                               t.setText(s);
                           }
                       }
                   }else{
                       if("0".equals(t.getText())){
                           sb.delete(0, sb.length());
                       }
                       sb.append(button.getLabel());
                       String s= sb.toString();
                       t.setText(s);

                   }
                }
            });
        }
        f.add(button);
    }
     
    public Cal(){
        f = new JFrame();
        f.setVisible(true);
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.BLACK);
        f.setSize(400, 600);
        f.setLayout(null);
        
        t = new JTextField();
        t.setBounds(100, 50, 250, 50);
        t.setFont(font);
        f.add(t);
        
        btn(70,380,50,50, new JButton("0"), 0);
        btn(10, 200, 50, 50, new JButton("1"), 1);
        btn(70, 200, 50, 50, new JButton("2"), 2);
        btn(130, 200, 50, 50, new JButton("3"), 3);
        btn(10, 260, 50, 50, new JButton("4"), 4);
        btn(70, 260, 50, 50, new JButton("5"), 5);
        btn(130, 260, 50, 50, new JButton("6"), 6);
        btn(10, 320, 50, 50, new JButton("7"), 7);
        btn(70, 320, 50, 50, new JButton("8"), 8);
        btn(130, 320, 50, 50, new JButton("9"), 9);
        btn(190, 200, 50, 50, new JButton("+"), 10);
        btn(190, 260, 50, 50, new JButton("-"), 11);
        btn(190, 320, 50, 50, new JButton("x"), 12);
        btn(190, 380, 50, 50, new JButton("/"), 13);
        btn(130,380,50,50, new JButton("="), 20);
        btn(130, 140, 110, 50, new JButton("AC"), 25);
        btn(10, 380, 50, 50, new JButton("."), 15);

    }
    public static void main(String[] args) {
        new Cal();
    }
}