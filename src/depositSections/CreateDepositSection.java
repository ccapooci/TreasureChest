package depositSections;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.LabelUsdText;
import components.UsdFormattedLabel;
import components.UsdFormattedTextField;
import windows.SavingsTracker;

public class CreateDepositSection extends JPanel {
	private SavingsTracker savingTrack = null;
	private UsdFormattedLabel leftoverUsd = null;
	private LabelUsdText item1 = null;
	private LabelUsdText item2 = null;
	private LabelUsdText item3 = null;
	private LabelUsdText item4 = null;
	private LabelUsdText item5 = null;
	private LabelUsdText item6 = null;
	private JTextField nameText = null;
	private UsdFormattedTextField totDepText = null;
	private	JComboBox recurrence = null;
	private JButton add = null;
	/**
	 * Create the panel.
	 */
	public CreateDepositSection(SavingsTracker savTrack) 
	{
		// JLabels
		JLabel createDeposit = new JLabel("Create a Deposit");
		item1 = new LabelUsdText(savTrack, "Item 1");
		item2 = new LabelUsdText(savTrack, "Item 2");
		item3 = new LabelUsdText(savTrack, "Item 3");
		item4 = new LabelUsdText(savTrack, "Item 4");
		item5 = new LabelUsdText(savTrack, "Item 5");
		item6 = new LabelUsdText(savTrack, "Item 6");
		JLabel name  = new JLabel("Deposit Name");
		JLabel totDeposit = new JLabel("Total Deposit");
		JLabel leftover = new JLabel("Leftover");
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();  // layout of the column
		GridBagConstraints gbc = new GridBagConstraints();  // constraints of the layout
			
		// Regular Textboxes
		nameText = new JTextField();
		
		// Combo boxes / drop down box
		recurrence = new JComboBox(); 
		
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
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(depositName, gbc);
        
        JPanel totalDepPan = new JPanel();
        totalDepPan.setLayout(new GridBagLayout());
        gbc.gridheight = 1;
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
        
        /*
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
        
     // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
		
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
        
     // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
		
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
        
     // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
		
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
        
     // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
		
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
        
     // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
		
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
        
     // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
		
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
        
     // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
		
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
        
     // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
		
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
        
        */
	}

}
