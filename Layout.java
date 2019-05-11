import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import java.awt.AWTEventMulticaster;

//This class defines the layout of the frame used. In this class we implement all the functionalities by calling
//the constructors of various classes.To decide which particular constructor to call we are using 
//different listeners inside this class.

public class Layout extends Editor
{
        int NumberOfWords=0;
        int NumberOfChars=0;
        private StyledDocument doc = new DefaultStyledDocument();
        private StyledEditorKit styledEditorKit = new StyledEditorKit();
        public Layout()
        {
                JScrollPane scrollPane = new JScrollPane(Panel_To_Type,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                Panel_To_Type.setDocument(doc);
                Panel_To_Type.setEditorKit(styledEditorKit);
                Mainframe.setLayout(new BorderLayout());
                JMenuBar MenuBar=new JMenuBar();
                JMenu file = new JMenu("File");
                JMenu edit = new JMenu("Edit");
                JMenu Case = new JMenu("Case");
                JPanel Panel_For_Text_Area=new JPanel(new BorderLayout());
                JPanel Count_Panel= new JPanel();
                JLabel Count_Of_CW = new JLabel();
                Count_Of_CW.setText("Words Selected: "+ NumberOfWords +" Characters Selected: "+NumberOfChars);
                Count_Panel.add(Count_Of_CW,BorderLayout.WEST);
                JMenuItem Save=new JMenuItem("SAVE");
                Save.addActionListener(new ActionListener() 
                {
                	@Override
                	public void actionPerformed(ActionEvent e) 
                	{
                		try {
                				Save saveobject=new Save();
                		} 
                		catch (FileNotFoundException e1) {
                			e1.printStackTrace();
                		}	
                	}
                });
                JMenuItem Find=new JMenuItem("FIND");
                Find.addActionListener(new ActionListener() {
                	@Override
                	public void actionPerformed(ActionEvent e) 
                	{
                		try {
                			Find find_object=new Find();
                		} catch (FileNotFoundException e1) {
                			e1.printStackTrace();
                		}
                	}
                });
		
                Panel_To_Type.addKeyListener(new KeyListener() {
                	@Override
                	public void keyTyped(KeyEvent e) {
                	char ch=e.getKeyChar();
                	if((int)ch==8 && Text_In_Editor.length()>0)
					{
						Text_In_Editor.deleteCharAt(Text_In_Editor.length()-1);
					}
                	else
					Text_In_Editor.append(ch);
                	}
			
                	@Override
                	public void keyReleased(KeyEvent e) {
				}
			
                	public void keyPressed(KeyEvent e) {
				}
		});
		Panel_For_Text_Area.add(scrollPane,BorderLayout.CENTER);
		JMenuItem Open=new JMenuItem("OPEN");
		Open.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Open open_object=new Open();
				}
				catch (FileNotFoundException e1) 
				{
					e1.printStackTrace();
				}	
			}
		});
                
		JMenuItem UPPERCASE=new JMenuItem("UPPERCASE");
		JMenuItem LOWERCASE=new JMenuItem("LOWERCASE");
		
                LOWERCASE.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Lowercase();
                    }
                });
                
                UPPERCASE.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Uppercase();
                    }
                });
                
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] Fonts = ge.getAvailableFontFamilyNames();
		String fontsize[]=new String[20];
		int startfont=10;
		for(int i=0;i<20;i++)
		{
			fontsize[i]=Integer.toString(startfont);
			startfont+=2;
		}
		//In the Fonttype,Fontsize,Italics,Underline,Bold,Cut,Copy,Paste
		//We have used the Styled Editor Kid to perform these actions using the action Listeners
		JComboBox Fonttype=new JComboBox(Fonts);
		Fonttype.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Name_Of_Font=String.valueOf(Fonttype.getSelectedItem()); 
                Action typeAction = new StyledEditorKit.FontFamilyAction(String.valueOf(Name_Of_Font), Name_Of_Font);
                typeAction.actionPerformed(e);
           }
		});
                
		JComboBox Fontsize=new JComboBox(fontsize);
		Fontsize.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int size = Integer.parseInt((String) Fontsize.getSelectedItem());
                        Action fontAction = new StyledEditorKit.FontSizeAction(String.valueOf(size), size);
                        fontAction.actionPerformed(e);
                    }
                });
                
        JMenuItem Bold = new JMenuItem("BOLD");
        Bold.addActionListener(new ActionListener() {
        			@Override
                    public void actionPerformed(ActionEvent e) {
        				Action setBold = new StyledEditorKit.BoldAction();
        				setBold.actionPerformed(e);
                    }
                });
                
        JMenuItem Italics = new JMenuItem("ITALICS");
        Italics.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         Action setItalics = new StyledEditorKit.ItalicAction();
                         setItalics.actionPerformed(e);
                    }
                });
                
        JMenuItem Underline = new JMenuItem("UNDERLINE");
        Underline.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         Action setUnderline = new StyledEditorKit.UnderlineAction();
                         setUnderline.actionPerformed(e);
                    }
                });
                
        JMenuItem Cut = new JMenuItem("CUT");
        Cut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         Action Cut = new StyledEditorKit.CutAction();
                         Cut.actionPerformed(e);
                    }
                });
                
        JMenuItem Copy = new JMenuItem("COPY");
        Copy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         Action Copy = new StyledEditorKit.CopyAction();
                         Copy.actionPerformed(e);
                    }
                });
                
        JMenuItem Paste = new JMenuItem("PASTE");
        Paste.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         Action Paste = new StyledEditorKit.PasteAction();
                         Paste.actionPerformed(e);
                    }
                });
                
        JMenuItem ReplaceFirst = new JMenuItem("REPLACE FIRST");
        ReplaceFirst.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Replace_First R_F=new Replace_First();
                    }
                });
                
        JMenuItem ReplaceAll = new JMenuItem("REPLACE ALL");
        ReplaceAll.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Replace_All R_A=new Replace_All();
                    }
                });
                
        Panel_To_Type.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(Panel_To_Type.getSelectedText()==null)
                        {
                        NumberOfChars=0;
                        NumberOfWords=0;
                        Count_Of_CW.setText("Words Selected: "+ NumberOfWords +" Characters Selected: "+NumberOfChars);
                        }
                        else
                        {    
                            try{
                                NumberOfWords= new Count_words().getSelectedWords();
                                NumberOfChars = new Count_Chars().getSelectedChars();
                                Count_Of_CW.setText("Words Selected: "+ NumberOfWords +" Characters Selected: "+NumberOfChars);
                                }
                            catch(NullPointerException ex)
                            {
                                ;
                            }
                        }
                    
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        try{
                        NumberOfWords= new Count_words().getSelectedWords();
                        NumberOfChars = new Count_Chars().getSelectedChars();
                        Count_Of_CW.setText("Words Selected: "+ NumberOfWords +" Characters Selected: "+NumberOfChars);
                        }
                        catch(NullPointerException ex)
                        {
                            ;
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
                

			JMenuItem shape=new JMenuItem("SHAPES");
			shape.addActionListener(new ActionListener() {
				@Override
					public void actionPerformed(ActionEvent e) {
						GeometricObjects go=new GeometricObjects();
				
					}
				});
        
		
                file.add(Save);
                file.add(Open);
                
                edit.add(Cut);
                edit.add(Copy);
                edit.add(Paste);
                edit.add(Bold);
                edit.add(Italics);
                edit.add(Underline);
                
                Case.add(UPPERCASE);
                Case.add(LOWERCASE);
                
                MenuBar.add(file);
                MenuBar.add(edit);
                MenuBar.add(Case);
                MenuBar.add(Fonttype);
                MenuBar.add(Fontsize);
                MenuBar.add(Find);
                MenuBar.add(ReplaceFirst);
                MenuBar.add(ReplaceAll);
                MenuBar.add(shape);
		        
                Mainframe.setJMenuBar(MenuBar);
                Mainframe.add(Panel_For_Text_Area,BorderLayout.CENTER);
                Mainframe.add(Count_Panel,BorderLayout.SOUTH);
                Mainframe.setTitle("TEXT EDITOR");
                Mainframe.setSize(1560,900);
                Mainframe.setVisible(true);
                Mainframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

//This Class opens up a JFrame which provides buttons for five different shapes
//It provides the ability to resize the shapes that have been drawn by dragging
class GeometricObjects extends Editor implements ActionListener{
    
	 int shape =0;  
	 int start1,end1;
	 boolean start1fixed=false,start2fixed=false;
	 int start2,end2;
	 
	 JFrame shape_Frame=new JFrame("SHAPES");
	 PaintPanel p2 = new PaintPanel(); 
	 GeometricObjects(){
	 JButton rectangle = new JButton("Rectangle");
     JButton square = new JButton("Square");
 	 JButton oval = new JButton ("Oval");
 	 JButton circle = new JButton ("Circle");
	 JButton roundedrectangle = new JButton("Rounded Rectangle");
	 JPanel bar = new JPanel();
	 rectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shape=1;  
				repaint();
		    	}
		});
	    
	 square.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shape=2;
		        }
		});
	    
	 oval.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				 shape=3;
		    	}
		});
	    
	 circle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 shape=4;
			}
		});
	    
	 roundedrectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		         shape=5;
		    }
		}); 
	    
	 bar.add(rectangle);
	 bar.add(square);
	 bar.add(oval);
	 bar.add(circle);
	 bar.add(roundedrectangle);
	 shape_Frame.add(bar,BorderLayout.NORTH);
	 shape_Frame.add(p2);
	 shape_Frame.setSize(1560,900);
	 shape_Frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	 shape_Frame.setVisible(true);
}
	 
public  class PaintPanel extends JPanel implements MouseMotionListener, MouseListener{
		public Point clickpoint;
		public PaintPanel() {
			addMouseListener(this);
			addMouseMotionListener(this);
		};
	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	        switch(shape){
	            case 1: g.drawRect(start1,start2,Math.abs(end1-start1),Math.abs(end2-start2) );
	                     
	            		repaint();
	                      break;
	            case 2: g.drawRect(start1,start2,Math.abs(end2-start2),Math.abs(end2-start2));
	                      repaint();
	                      break;
	            case 3: g.drawOval(start1,start2,Math.abs(end1-start1), Math.abs(end2-start2));
	                      repaint();
	                      break;
	            case 4: g.drawOval(start1,start2,Math.abs(end2-start2), Math.abs(end2-start2));
	                      repaint();
	                      break;
	            case 5: g.drawRoundRect(start1,start2,Math.abs(end1-start1),Math.abs(end2-start2),100,100);
	                      repaint();
	                      break;
	        }        
	    }
	
	    @Override
		public void mouseClicked(MouseEvent e) {
	    }
	    
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			clickpoint = new Point(e.getPoint());
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
	    	start1 = Math.min(e.getX(), clickpoint.x);
	    	start2 = Math.min(e.getY(), clickpoint.y);
            end1 = Math.max(e.getX(), clickpoint.x);
            end2 = Math.max(e.getY(), clickpoint.y);
            repaint();
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
		}	    
	}
}