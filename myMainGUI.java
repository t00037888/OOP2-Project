import javax.swing.*;

import java.awt.event.*;

import java.awt.*;

public class myMainGUI extends JFrame

{
	JPanel societiesPanel,membersPanel,committiesPanel;
	JLabel societyNameLabel,societyMeetingTimeLabel,committiesNameLabel;
	JLabel membersNameLabel,memberstNumberLabel,membersCourseTitleLabel,membersCourseYearLabel,membersMobileLabel,membersEmailLabel;
	JTextField memberstNumberField,membersCourseTitleField,membersCourseYearField,membersEmailField,membersMobileField;
	JTextField societyNameField,societyMeetingTimeField,membersNameField,committiesNameField;
	JButton societySubmit,membersSubmit,committiesSubmit;
	int choiceOne,choiceTwo,totalProcessed=0,totalAge=0,oldestAge=0,youngestAge=0;
	String societyNames[] = new String[100],memberNames[] = new String[100],committeeNames[] = new String[100];
	String societyMeetingTimes[] = new String[100];
	String societyName, memberName, committeeName, societyMeetingTime;
	String displaySocietyName="",displayMemberName="",displayCommitteeName="",displaySocietyMeetingTime="";
	String displaySocietyNames="",displayMemberNames="",displayCommitteeNames="",displaySocietyMeetingTimes="";
	//private JMenuBar myGUIMenuBar;
	
	public myMainGUI()
		
	{		 
		/*FlowLayout flowLayout = new FlowLayout();

		setLayout(flowLayout);*/
		     
		setTitle("Main Page");
		
		setSize(300,500);
		
		setLocation(250,250);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		JMenuBar myGUIMenuBar = new JMenuBar();
		
		setJMenuBar(myGUIMenuBar);
		
		
		//JMenu
		
		JMenu file = new JMenu("File");
		myGUIMenuBar.add(file);
		
		JMenu societies = new JMenu("Societies");
		myGUIMenuBar.add(societies);
		
		JMenu members = new JMenu("Members");
		myGUIMenuBar.add(members);
		
		JMenu committees = new JMenu("Committees");
		myGUIMenuBar.add(committees); 
		
		//JMenuItems for File
		
		JMenuItem load = new JMenuItem("Load");		
		file.add(load);
		load.addActionListener(new myHandlerF());
		
		JMenuItem save = new JMenuItem("Save");		
		file.add(save);
		save.addActionListener(new myHandlerF());
		
		JMenuItem quit = new JMenuItem("Quit");		
		file.add(quit);
		quit.addActionListener(new myHandlerF());
		
		//JMenuItems for Societies
		
		JMenuItem createS = new JMenuItem("Create Society");		
		societies.add(createS);
		createS.addActionListener(new myHandlerS());
		
		JMenuItem editS = new JMenuItem("Edit Society");		
		societies.add(editS);
		editS.addActionListener(new myHandlerS());
		
		JMenuItem viewS = new JMenuItem("View Society");		
		societies.add(viewS);
		viewS.addActionListener(new myHandlerS());
		
		JMenuItem viewAllS = new JMenuItem("View All Societies");		
		societies.add(viewAllS);
		viewAllS.addActionListener(new myHandlerS());
		
		//JMenuItems for Members
		
		JMenuItem createM = new JMenuItem("Create Member");		
		members.add(createM);
		createM.addActionListener(new myHandlerM());
		
		JMenuItem editM = new JMenuItem("Edit Member");		
		members.add(editM);
		editM.addActionListener(new myHandlerM());
		
		JMenuItem viewM = new JMenuItem("View Member");		
		members.add(viewM);
		viewM.addActionListener(new myHandlerM());
		
		JMenuItem viewAllM = new JMenuItem("View All Members");		
		members.add(viewAllM);
		viewAllM.addActionListener(new myHandlerM());
		
		//JMenuItems for Committees
		
		JMenuItem createC = new JMenuItem("Create Committee");		
		committees.add(createC);
		createC.addActionListener(new myHandlerC());
		
		JMenuItem editC = new JMenuItem("Edit Committee");		
		committees.add(editC);
		editC.addActionListener(new myHandlerC());
		
		JMenuItem viewC = new JMenuItem("View Committee");		
		committees.add(viewC);
		viewC.addActionListener(new myHandlerC());
		
		JMenuItem viewAllC = new JMenuItem("View All Committies");		
		committees.add(viewAllC);
		viewAllC.addActionListener(new myHandlerC());
		
	//Create JKPanels
		societiesPanel = new JPanel();
		societiesPanel.setVisible(false);
		societiesPanel.setSize(300,300);
		add(societiesPanel);
		createSocietiesPanelComponents();
		
		membersPanel = new JPanel();
		membersPanel.setVisible(false);
		membersPanel.setSize(300,400);
		add(membersPanel);
		createMembersPanelComponents();
		
		committiesPanel = new JPanel();
		committiesPanel.setVisible(false);
		committiesPanel.setSize(300,300);
		add(committiesPanel);
		createCommittiesPanelComponents();
		
		
				
		
		
	}//End Menu Constructor
	
	
	
	public static void main(String args[])
		
	{
		
		myMainGUI myGUI = new myMainGUI();
		myGUI.setVisible(true);
		
		
	}
	
	
	private void createSocietiesPanelComponents()
		
	{
		
		societyNameLabel = new JLabel("Enter Society Name");
		societiesPanel.add(societyNameLabel);
		
		societyNameField = new JTextField(20);
		societiesPanel.add(societyNameField);
		
		societyMeetingTimeLabel = new JLabel("Enter Meeting Time");
		societiesPanel.add(societyMeetingTimeLabel);
		
		societyMeetingTimeField = new JTextField(20);
		societiesPanel.add(societyMeetingTimeField);
		
		societySubmit = new JButton("Submit");
		societiesPanel.add(societySubmit);
		societySubmit.addActionListener(new societySubmitHandler());
		
		
		
	}
	
	private void createMembersPanelComponents()
	
	{
		
		membersNameLabel = new JLabel("Enter Member Name");
		membersPanel.add(membersNameLabel);
		
		membersNameField = new JTextField(20);
		membersPanel.add(membersNameField);
		
		memberstNumberLabel = new JLabel("Enter T-Number");
		membersPanel.add(memberstNumberLabel);
		
		memberstNumberField = new JTextField(20);
		membersPanel.add(memberstNumberField);
		
		membersCourseTitleLabel = new JLabel("Enter Course Title");
		membersPanel.add(membersCourseTitleLabel);
		
		membersCourseTitleField = new JTextField(20);
		membersPanel.add(membersCourseTitleField);
		
		membersCourseYearLabel = new JLabel("Enter Course Year");
		membersPanel.add(membersCourseYearLabel);
		
		membersCourseYearField = new JTextField(20);
		membersPanel.add(membersCourseYearField);
		
		membersMobileLabel = new JLabel("Enter Mobile");
		membersPanel.add(membersMobileLabel);
		
		membersMobileField = new JTextField(20);
		membersPanel.add(membersMobileField);
		
		membersEmailLabel = new JLabel("Enter Mobile");
		membersPanel.add(membersEmailLabel);
		
		membersEmailField = new JTextField(20);
		membersPanel.add(membersEmailField);
		
		membersSubmit = new JButton("Submit");
		membersPanel.add(membersSubmit);
		membersSubmit.addActionListener(new memberSubmitHandler());
		
	}
	
	private void createCommittiesPanelComponents()
		
	{
		
		committiesNameLabel = new JLabel("Enter Society Name");
		committiesPanel.add(committiesNameLabel);
		
		committiesNameField = new JTextField(20);
		committiesPanel.add(committiesNameField);
		
		committiesSubmit = new JButton("Submit");
		committiesPanel.add(committiesSubmit);
		committiesSubmit.addActionListener(new committiesSubmitHandler());
		
		
		
	}
	
	public class societySubmitHandler implements ActionListener
		
	{
		public void actionPerformed(ActionEvent event)
			
		{
			
			societyNames[totalProcessed] += societyNameField.getText();
			
			societyMeetingTimes[totalProcessed] += societyMeetingTimeField.getText();
			
			
			if(!societyNames[totalProcessed].equals("") && !societyMeetingTimes[totalProcessed].equals(""))
			{
				
				societyName = societyNameField.getText();
				displaySocietyName = societyName;
				displaySocietyNames += displaySocietyName + "\n";
				
				societyMeetingTime = societyMeetingTimeField.getText();
				displaySocietyMeetingTime = societyMeetingTime;
				displaySocietyMeetingTimes += displaySocietyMeetingTime + "\n";
				
				
			}
			
			
			choiceOne = JOptionPane.showConfirmDialog(null,"Is this name correct?","",
			JOptionPane.YES_NO_OPTION);
			
			if(choiceOne == JOptionPane.YES_OPTION)
				
			{
				
				JOptionPane.showMessageDialog(null,"You have registered " + displaySocietyName,"",
				JOptionPane.INFORMATION_MESSAGE);
				
				societyNameField.setText("");
				societyNameField.requestFocus();
				
				
				choiceTwo = JOptionPane.showConfirmDialog(null,"Would you like to registr another society?","",
				JOptionPane.YES_NO_OPTION);
				
				if(choiceTwo == JOptionPane.NO_OPTION)
					
				{
					
					societiesPanel.setVisible(false);
	
				}
				
			
			}
			
		}
		
	}//end societysubmit handler
	
	public class memberSubmitHandler implements ActionListener
		
	{
		public void actionPerformed(ActionEvent event)
			
		{
			
			memberNames[totalProcessed] += membersNameField.getText();
			
			if(!memberNames[totalProcessed].equals(""))
			{
				
				memberName = membersNameField.getText();
				displayMemberName += memberName;
				displayMemberNames += displayMemberName + "\n";			
				
			}
			
			
			
			
			choiceOne = JOptionPane.showConfirmDialog(null,"Is this name correct?","",
			JOptionPane.YES_NO_OPTION);
			
			if(choiceOne == JOptionPane.YES_OPTION)
				
			{
				
				JOptionPane.showMessageDialog(null,"You have registered " + displayMemberName,"",
				JOptionPane.INFORMATION_MESSAGE);
				
				membersNameField.setText("");
			
			}
			
			membersNameField.requestFocus();
			
			
		}
	
	}//End MembersSubmit Handler
	
	public class committiesSubmitHandler implements ActionListener
		
	{
		public void actionPerformed(ActionEvent event)
			
		{
			
			committeeNames[totalProcessed] += committiesNameField.getText();
			
			if(!committeeNames[totalProcessed].equals(""))
			{
				
				String committeeName = committiesNameField.getText();
				displayCommitteeName += committeeName;
				
				
			}
			
			
			
			
			choiceOne = JOptionPane.showConfirmDialog(null,"Is this name correct?","",
			JOptionPane.YES_NO_OPTION);
			
			if(choiceOne == JOptionPane.YES_OPTION)
				
			{
				
				JOptionPane.showMessageDialog(null,"You have registered " + displayCommitteeName,"",
				JOptionPane.INFORMATION_MESSAGE);
				
				societyNameField.setText("");
			
			}
			
		}
		
	}//end committiessubmit handler
	
	
	
	public class myHandlerF implements ActionListener
		
	{
		
		public void actionPerformed(ActionEvent event)
			
		{
			
			if(event.getActionCommand().equals("Load"))
					
			{
				
				JOptionPane.showMessageDialog(null,"Load","Load",
				JOptionPane.INFORMATION_MESSAGE);
					
			}
				
			if(event.getActionCommand().equals("Save"))
					
			{
					
				JOptionPane.showMessageDialog(null,"Save","Save",
				JOptionPane.INFORMATION_MESSAGE);
					
			}
				
			
			if(event.getActionCommand().equals("Quit"))
					
			{
					
				JOptionPane.showMessageDialog(null,"Good Bye","Quit",
				JOptionPane.INFORMATION_MESSAGE);
					
				System.exit(0);
					
			}
		
		}
	
	}//End MyHandlerF
	
	
//myHandlerS
	public class myHandlerS implements ActionListener
			
	{
			
		public void actionPerformed(ActionEvent event)
				
		{
				
			if(event.getActionCommand().equals("Create Society"))
					
			{	
				
				societyNameLabel.setVisible(true);
				societiesPanel.setVisible(true);
				societyNameField.requestFocus();	
					
			}
				
			if(event.getActionCommand().equals("Edit Society"))
					
			{
					
				JOptionPane.showMessageDialog(null,"Edit Society","Edit",
				JOptionPane.INFORMATION_MESSAGE);
					
			}
				
			if(event.getActionCommand().equals("View Society"))
					
			{
					
				JOptionPane.showMessageDialog(null,displaySocietyNames,"View",
				JOptionPane.INFORMATION_MESSAGE);
					
			}
			
			if(event.getActionCommand().equals("View All Societies"))
					
			{
					
				JOptionPane.showMessageDialog(null,"View All Societies","View All",
				JOptionPane.INFORMATION_MESSAGE);
					
			}
				
		}
			
	}//End MyHandlerS

	public class myHandlerM implements ActionListener
			
	{
			
		public void actionPerformed(ActionEvent event)
				
		{
				
			if(event.getActionCommand().equals("Create Member"))
					
			{
					
				membersNameLabel.setVisible(true);
				membersPanel.setVisible(true);
				membersNameField.requestFocus();
					
			}
				
			if(event.getActionCommand().equals("Edit Member"))
					
			{
					
				JOptionPane.showMessageDialog(null,"Edit Member","Edit",
				JOptionPane.INFORMATION_MESSAGE);
					
			}
				
			if(event.getActionCommand().equals("View Member"))
					
			{
					
				JOptionPane.showMessageDialog(null,"View Member","View",
				JOptionPane.INFORMATION_MESSAGE);
					
			}
			
			if(event.getActionCommand().equals("View All Members"))
					
			{
					
				JOptionPane.showMessageDialog(null,"View All Members","View All",
				JOptionPane.INFORMATION_MESSAGE);
					
			}
			
		}
			
	}//End MyHandlerM
	
	public class myHandlerC implements ActionListener
		
	{
			
		public void actionPerformed(ActionEvent event)
				
		{
				
			if(event.getActionCommand().equals("Create Committee"))
					
			{
					
				committiesNameLabel.setVisible(true);
				committiesPanel.setVisible(true);
				committiesNameField.requestFocus();
					
			}
				
			if(event.getActionCommand().equals("Edit Committee"))
					
			{
					
				JOptionPane.showMessageDialog(null,"Edit Committee","Edit",
				JOptionPane.INFORMATION_MESSAGE);
					
			}
				
			if(event.getActionCommand().equals("View Committee"))
					
			{
					
				JOptionPane.showMessageDialog(null,"View Committee","View",
				JOptionPane.INFORMATION_MESSAGE);
				
			}
		
			if(event.getActionCommand().equals("View All Committies"))
				
			{
				
				JOptionPane.showMessageDialog(null,"View All Committies","View All",
				JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		
	}//End MyActionHandlerC
	
}
