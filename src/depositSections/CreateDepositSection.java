package depositSections;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.DateSelector;
import components.LabelUsdText;
import components.UsdFormattedLabel;
import components.UsdFormattedTextField;
import windows.SavingsTracker;

public class CreateDepositSection extends JPanel {
	private SavingsTracker savingTrack = null;
	private UsdFormattedLabel leftoverUsd = null;
	private LabelUsdText items[] = null;
	private JTextField nameText = null;
	private UsdFormattedTextField totDepText = null;
	private	JComboBox recurrence = null;
	private JButton add = null;
	private String recurrOption[] = null;
	private DateSelector dateSel = null;
	/**
	 * Create the panel.
	 */
	public CreateDepositSection(SavingsTracker savTrack) 
	{
		// JLabels
		JLabel createDeposit = new JLabel("Create a Deposit");
		items = new LabelUsdText[6];
		JLabel name  = new JLabel("Deposit Name");
		JLabel totDeposit = new JLabel("Total Deposit");
		JLabel leftover = new JLabel("Leftover");
		JLabel nxtOcc = new JLabel("Next Occurrence");
		dateSel = new DateSelector();
		
		GridBagLayout gridBagLayout = new GridBagLayout();  // layout of the column
		GridBagConstraints gbc = new GridBagConstraints();  // constraints of the layout
			
		// Regular Textboxes
		nameText = new JTextField();
		
		// Combo boxes / drop down box
		recurrOption = new String[5];
		recurrOption[0] = "One Time";
		recurrOption[1] = "Daily";
		recurrOption[2] = "Weekly";
		recurrOption[3] = "Biweekly"; 
		recurrOption[4] = "Monthly";		
		recurrence = new JComboBox<String>(recurrOption); 
		
		savingTrack = savTrack;
		leftoverUsd = new UsdFormattedLabel(savTrack);
		totDepText = new UsdFormattedTextField(savTrack);
		add = new JButton("Add Deposit");
		
		setLayout(gridBagLayout);
		
		// create the layout of the pieces on this panel
        // the top will say create a deposit
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;//GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(createDeposit, gbc);
		
        JPanel depositName = new JPanel();
        depositName.setLayout(new GridBagLayout());
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        depositName.add(name, gbc);
        
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        depositName.add(nameText, gbc);
        
        // create the layout of the pieces on this panel
        // then ask for the name of the deposit
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(depositName, gbc);
        
        JPanel totalDepPan = new JPanel();
        totalDepPan.setLayout(new GridBagLayout());
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        totalDepPan.add(totDeposit, gbc);
        
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        totalDepPan.add(totDepText, gbc);
        
     // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(totalDepPan, gbc);
		
        
        JPanel leftoverPan = new JPanel();
        leftoverPan.setLayout(new GridBagLayout());
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        leftoverPan.add(leftover, gbc);
        
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        leftoverPan.add(leftoverUsd, gbc);
        
     // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 2;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(leftoverPan, gbc);
        
        for(int i = 1; i <= 6; i++)
        {
        	items[i-1] = new LabelUsdText(savTrack, "Item " + i);
        	gbc.gridheight = 1;
            gbc.gridx = 1;
            gbc.gridy = 2 + i;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 0.5;
            gbc.weighty = 0.5;
            add(items[i-1], gbc);
        }
        
           
        // create the layout of the pieces on this panel
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(recurrence, gbc);
        
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(nxtOcc, gbc);
        
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(dateSel, gbc);
        
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(add, gbc);
        
        add.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	double itDeps[] = new double[6];
            	int i = 0;
            	for(LabelUsdText item : items)
            	{
            		itDeps[i] = item.getValue();
            		i++;
            	}
            	
            	savingTrack.addDeposit(nameText.getText(),
            			totDepText.getValue(),
            			itDeps,
            			i,
            			(String)recurrence.getSelectedItem(),
            			dateSel.getDate());
            }

	    });
        
        
        
	}

}
