package Cipher;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class Ceaser extends JFrame {

	private JPanel contentPane;
	private JTextField t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ceaser frame = new Ceaser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ceaser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane t1 = new JTextPane();
		t1.setText("");
		t1.setBounds(184, 33, 113, 20);
		contentPane.add(t1);
		
		JTextArea t2 = new JTextArea();
		t2.setBounds(184, 75, 113, 22);
		contentPane.add(t2);
		
		JButton b1 = new JButton("Encrypt");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] a= {'a','b','c','d','e','f','g','h','i','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
				String pt=t1.getText();
				
				
				pt=pt.toLowerCase().replaceAll("\\s", "");
				
				StringBuffer sb=new StringBuffer(pt);
				
				int i,j,u=0;
				String[] spl=new String[50];
				String ch="";
				

				for(i=0,j=1;j<=sb.length();j=j+2,i=i+2) {
					if(j==sb.length()&&j%2!=0) {
						sb=sb.append('z');
					}
					
					if(sb.charAt(i)!=sb.charAt(j)) {
						
						ch = Character.toString(sb.charAt(i));
						ch=ch+sb.charAt(j);
						spl[u]=ch;
						u++;
						
					}
					else {
						ch = Character.toString(sb.charAt(i));

						sb=sb.insert(j, 'x');
						ch=ch+sb.charAt(j);

						spl[u]=ch;
						u++;
						
					}
				}
				System.out.println();
				
				System.out.println("Plaintext : "+pt);
				
				System.out.println();
				
				System.out.println(sb);
				
				System.out.println();
				
				
				for(i=0;i<sb.length()/2;i++){
					System.out.print(spl[i]+" ");					
				}
			
				System.out.println();
				System.out.println();
				
				
				String s=t2.getText();
				s=s.toLowerCase().replaceAll("\\s", "");
				char[][] b=new char[5][5];
				char[] c=new char[30];
				char[] d=new char[30];
				
				int k=0,p=0,z=0;
				int x,y;
				
				
				for(x=0;x<s.length();x++) {
					c[x]=s.charAt(x);
					
				}
				
				for (x = 0; x < a.length; x++)
		        {		            		        
		            for (y = 0; y < c.length; y++)
		                if (a[x] == c[y])
		                    break;		 
		            if (y == c.length) {
		                d[p]=a[x];
		                p++;
		            }
		        }
				
				
				int m=s.length();
				for(i=0;i<5;i++) {
					for(j=0;j<5;j++){
						if(k<m) {
							b[i][j]=s.charAt(k);			
						}
						else {
							
							b[i][j]=d[z];
							z++;
						}
						k++;
					}	
				}
				
				for(i=0;i<5;i++) {
					for(j=0;j<5;j++) {
						System.out.print(b[i][j]+"  ");
					}
					System.out.println();
				}
				
				System.out.println();
				
				int row,col,r,v;
				String[] sp=new String[50];
				
				for(y=0;y<sb.length()/2;y++) {
				for(i=0;i<5;i++) {
					for(j=0;j<5;j++) {
						
						if(spl[y].charAt(0)==b[i][j]) {
							for(x=0;x<5;x++) {
								if(spl[y].charAt(1)==b[i][x]) {
									row=(j+1)%5;
									col=(x+1)%5;
									sp[y]=Character.toString(b[i][row]);
									sp[y]=sp[y]+b[i][col];
									break;
								}
								else if(spl[y].charAt(1)==b[x][j]) {
									row=(i+1)%5;
									col=(x+1)%5;
									sp[y]=Character.toString(b[row][j]);
									sp[y]=sp[y]+b[col][j];
									break;
								}
								
									for(r=0;r<5;r++) {
										for(v=0;v<5;v++) {
											if(spl[y].charAt(1)==b[r][v]) {
												sp[y]=Character.toString(b[i][v]);
												sp[y]=sp[y]+b[r][j];
												break;
											}
										}
										
									}								
							}
						}
					}
					}
				}
				for(i=0;i<sb.length()/2;i++) {
				
				System.out.print(sp[i]+" ");
				}
				
				System.out.println();
				
				String enc="";
				
				for(i=0;i<sb.length()/2;i++) {
					enc=enc+sp[i];
				}
				
				t3.setText(enc);
			}
		});
		b1.setBounds(328, 76, 85, 23);
		contentPane.add(b1);
		
		t3 = new JTextField();
		t3.setBounds(180, 124, 117, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel plain = new JLabel("Enter the plain text : ");
		plain.setBounds(37, 33, 148, 14);
		contentPane.add(plain);
		
		JLabel key = new JLabel("Enter the key : ");
		key.setBounds(37, 77, 104, 14);
		contentPane.add(key);
		
		
		
		JLabel enc = new JLabel("Encrypted data : ");
		enc.setBounds(37, 127, 104, 14);
		contentPane.add(enc);
		
		
		
	}
}
