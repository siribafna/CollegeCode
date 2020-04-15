package mycalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class Calculator extends JFrame implements ActionListener {
	JButton addButton, subButton, multButton, diviButton, noUseButton, openPButton, modButton, endPButton, wordButton,
			clearButton, sevenButton, fourButton, oneButton, clearAllButton, eightButton, fiveButton, twoButton,
			zeroButton, backspaceButton, nineButton, sixButton, threeButton, equalButton, pointButton, powerButton,
			aButton, bButton, cButton, dButton, eButton, fButton;
	JToggleButton hexaButton, decButton, binButton, octButton;
	JLabel hexaLabel, answerLabel, decLabel, octLabel, binLabel, label5, label6;
	JTextArea equationTextField, textField2;
	JPanel buttonPanel, labelsPanel, convertPanel, titlePanel;
	GridBagConstraints c = new GridBagConstraints();
	boolean isPressable = true;
	int answer2;
	long answer3;
	QWordConversion qWordConversion;
	HexaConversion hexConv;
	OctalConversion octConv;
	BinaryConversion binConv;

	public Calculator() {
		// initialize classes to access different evaluate expressions based on "hex,
		// dec, oct, bin"
		qWordConversion = new QWordConversion();
		hexConv = new HexaConversion();
		octConv = new OctalConversion();
		binConv = new BinaryConversion();

		// UI setup
		labelsPanel = new JPanel();
		labelsPanel.setLayout(new BorderLayout());

		convertPanel = new JPanel();
		convertPanel.setLayout(new GridLayout(4, 2, 0, 0));

		equationTextField = new JTextArea("");
		equationTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		equationTextField.setBackground(null);
		labelsPanel.add(equationTextField, BorderLayout.SOUTH);

		answerLabel = new JLabel("");
		answerLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 45));
		labelsPanel.add(answerLabel, BorderLayout.CENTER);

		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());

		JButton stuButton = new JButton("|||");
		titlePanel.add(stuButton, BorderLayout.WEST);
		label6 = new JLabel("Programmer");
		label6.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		titlePanel.add(label6, BorderLayout.CENTER);

		c.anchor = GridBagConstraints.CENTER;
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());

		hexaButton = new JToggleButton("Hexa");
		c.gridx = 0;
		c.gridy = 0;
		hexaButton.setSelected(false);
		buttonPanel.add(hexaButton, c);

		hexaLabel = new JLabel("0");
		c.gridx = 1;
		c.gridy = 0;
		buttonPanel.add(hexaLabel, c);

		decButton = new JToggleButton("Dec");
		c.gridx = 0;
		c.gridy = 1;
		decButton.setSelected(true);
		buttonPanel.add(decButton, c);
		decLabel = new JLabel("0");
		c.gridx = 1;
		c.gridy = 1;
		buttonPanel.add(decLabel, c);

		octButton = new JToggleButton("Oct");
		c.gridx = 0;
		c.gridy = 2;
		octButton.setSelected(false);
		buttonPanel.add(octButton, c);
		octLabel = new JLabel("0");
		c.gridx = 1;
		c.gridy = 2;
		buttonPanel.add(octLabel, c);

		binButton = new JToggleButton("Bin");
		c.gridx = 0;
		c.gridy = 3;
		binButton.setSelected(false);
		buttonPanel.add(binButton, c);
		binLabel = new JLabel("0");
		c.gridx = 1;
		c.gridy = 3;
		buttonPanel.add(binLabel, c);

		noUseButton = new JButton("...");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 0;
		c.gridy = 4;
		buttonPanel.add(noUseButton, c);

		noUseButton = new JButton("Lsh");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 0;
		c.gridy = 5;
		buttonPanel.add(noUseButton, c);

		powerButton = new JButton("^");
		c.gridx = 0;
		c.gridy = 6;
		buttonPanel.add(powerButton, c);
		powerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equationTextField.append("^");
			}
		});

		aButton = new JButton("A"); // change
		// noUseButton.setForeground(Color.GRAY);
		c.gridx = 0;
		c.gridy = 7;
		buttonPanel.add(aButton, c);
		aButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {
					if (hexaButton.isSelected()) {
						equationTextField.append("a"); // only appends if hexa is selected
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("BYTE")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("a");
						setNumberConversionsForIntForHex();
					}
				}

				if (wordButton.getText().equals("DWORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("a");
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("QWORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("a");
						setNumberConversionsForLongForHex();
					}
				}
			}
		});

		cButton = new JButton("C");
		/// noUseButton.setForeground(Color.GRAY);
		c.gridx = 0;
		c.gridy = 8;
		buttonPanel.add(cButton, c);
		cButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("c");
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("BYTE")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("c");
						setNumberConversionsForIntForHex();
					}
				}

				if (wordButton.getText().equals("DWORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("c");
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("QWORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("c");
						setNumberConversionsForLongForHex();
					}
				}
			}
		});

		eButton = new JButton("E");
		c.gridx = 0;
		c.gridy = 9;
		buttonPanel.add(eButton, c);
		eButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("e");
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("BYTE")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("e");
						setNumberConversionsForIntForHex();
					}
				}

				if (wordButton.getText().equals("DWORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("e");
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("QWORD")) {
					if (hexaButton.isSelected()) {
						equationTextField.append("e");
						setNumberConversionsForLongForHex();
					}
				}
			}
		});

		openPButton = new JButton("(");
		c.gridx = 0;
		c.gridy = 10;
		buttonPanel.add(openPButton, c);
		openPButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equationTextField.append("(");
			}
		});
		////

		noUseButton = new JButton("..");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 1;
		c.gridy = 4;
		buttonPanel.add(noUseButton, c);

		noUseButton = new JButton("Rsh");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 1;
		c.gridy = 5;
		buttonPanel.add(noUseButton, c);

		modButton = new JButton("Mod");
		c.gridx = 1;
		c.gridy = 6;
		buttonPanel.add(modButton, c);
		modButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equationTextField.append("%");
			}
		});

		bButton = new JButton("B");
		c.gridx = 1;
		c.gridy = 7;
		buttonPanel.add(bButton, c);
		bButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("b");
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("BYTE")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("b");
						setNumberConversionsForIntForHex();
					}
				}

				if (wordButton.getText().equals("DWORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("b");
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("QWORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("b");
						setNumberConversionsForLongForHex();
					}
				}
			}
		});

		dButton = new JButton("D");
		c.gridx = 1;
		c.gridy = 8;
		buttonPanel.add(dButton, c);
		dButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("d");
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("BYTE")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("d");
						setNumberConversionsForIntForHex();
					}
				}

				if (wordButton.getText().equals("DWORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("d");
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("QWORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("d");
						setNumberConversionsForLongForHex();
					}
				}
			}
		});

		fButton = new JButton("F");
		c.gridx = 1;
		c.gridy = 9;
		buttonPanel.add(fButton, c);
		fButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("f");
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("BYTE")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("f");
						setNumberConversionsForIntForHex();
					}
				}

				if (wordButton.getText().equals("DWORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("f");
						setNumberConversionsForIntForHex();
					}
				}
				if (wordButton.getText().equals("QWORD")) {

					if (hexaButton.isSelected()) {
						equationTextField.append("f");
						setNumberConversionsForLongForHex();
					}
				}
			}
		});

		endPButton = new JButton(")");
		c.gridx = 1;
		c.gridy = 10;
		buttonPanel.add(endPButton, c);
		endPButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equationTextField.append(")");
			}
		});

		wordButton = new JButton("WORD");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		buttonPanel.add(wordButton, c);
		wordButton.addActionListener(this);

		noUseButton = new JButton("Or");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 2;
		c.gridy = 5;
		buttonPanel.add(noUseButton, c);

		clearButton = new JButton("CE");
		c.gridx = 2;
		c.gridy = 6;
		buttonPanel.add(clearButton, c);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answerLabel.setText("");
				hexaLabel.setText("0");
				decLabel.setText("0");
				octLabel.setText("0");
				binLabel.setText("0");
				answer2 = 0;

			}
		});

		sevenButton = new JButton("7");
		c.gridx = 2;
		c.gridy = 7;
		buttonPanel.add(sevenButton, c);
		sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {
					equationTextField.append("7");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}

				}
				if (wordButton.getText().equals("BYTE")) {
					equationTextField.append("7");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}

				if (wordButton.getText().equals("DWORD")) {
					equationTextField.append("7");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("QWORD")) {
					equationTextField.append("7");
					if (decButton.isSelected())
						setNumberConversionsForLongForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForLongForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForLongForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForLongForBin();
					}
				}

			}
		});

		fourButton = new JButton("4");
		c.gridx = 2;
		c.gridy = 8;
		buttonPanel.add(fourButton, c);
		fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {
					equationTextField.append("4");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("BYTE")) {
					equationTextField.append("4");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("DWORD")) {
					equationTextField.append("4");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("QWORD")) {
					equationTextField.append("4");
					if (decButton.isSelected())
						setNumberConversionsForLongForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForLongForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForLongForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForLongForBin();
					}
				}
			}
		});

		oneButton = new JButton("1");
		c.gridx = 2;
		c.gridy = 9;
		buttonPanel.add(oneButton, c);
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {
					equationTextField.append("1");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("BYTE")) {
					equationTextField.append("1");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("DWORD")) {
					equationTextField.append("1");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("QWORD")) {
					equationTextField.append("1");
					if (decButton.isSelected())
						setNumberConversionsForLongForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForLongForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForLongForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForLongForBin();
					}
				}
			}
		});

		noUseButton = new JButton("+/-");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 2;
		c.gridy = 10;
		buttonPanel.add(noUseButton, c);

		noUseButton = new JButton("MS");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 4;
		c.gridy = 4;
		buttonPanel.add(noUseButton, c);

		noUseButton = new JButton("Xor");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 3;
		c.gridy = 5;
		buttonPanel.add(noUseButton, c);

		clearAllButton = new JButton("C");
		c.gridx = 3;
		c.gridy = 6;
		buttonPanel.add(clearAllButton, c);
		clearAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answerLabel.setText("");
				equationTextField.setText("");
				hexaLabel.setText("0");
				decLabel.setText("0");
				octLabel.setText("0");
				binLabel.setText("0");
				answer2 = 0;
			}
		});

		eightButton = new JButton("8");
		c.gridx = 3;
		c.gridy = 7;
		buttonPanel.add(eightButton, c);
		eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {
					equationTextField.append("8");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("BYTE")) {
					equationTextField.append("8");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("DWORD")) {
					equationTextField.append("8");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("QWORD")) {
					equationTextField.append("8");
					if (decButton.isSelected())
						setNumberConversionsForLongForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForLongForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForLongForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForLongForBin();
					}
				}
			}
		});

		fiveButton = new JButton("5");
		c.gridx = 3;
		c.gridy = 8;
		buttonPanel.add(fiveButton, c);
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {
					equationTextField.append("5");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("BYTE")) {
					equationTextField.append("5");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("DWORD")) {
					equationTextField.append("5");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("QWORD")) {
					equationTextField.append("5");
					if (decButton.isSelected())
						setNumberConversionsForLongForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForLongForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForLongForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForLongForBin();
					}
				}
			}
		});

		twoButton = new JButton("2");
		c.gridx = 3;
		c.gridy = 9;
		buttonPanel.add(twoButton, c);
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {
					equationTextField.append("2");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("BYTE")) {
					equationTextField.append("2");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("DWORD")) {
					equationTextField.append("2");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("QWORD")) {
					equationTextField.append("2");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForLongForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForLongForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForLongForBin();
					}
				}
			}
		});

		zeroButton = new JButton("0");
		c.gridx = 3;
		c.gridy = 10;
		buttonPanel.add(zeroButton, c);
		zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {
					equationTextField.append("0");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("BYTE")) {
					equationTextField.append("0");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("DWORD")) {
					equationTextField.append("0");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("QWORD")) {
					equationTextField.append("0");
					if (decButton.isSelected())
						setNumberConversionsForLongForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForLongForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForLongForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForLongForBin();
					}
				}
			}
		});

		noUseButton = new JButton("M");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 5;
		c.gridy = 4;
		buttonPanel.add(noUseButton, c);

		noUseButton = new JButton("Not");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 4;
		c.gridy = 5;
		buttonPanel.add(noUseButton, c);

		backspaceButton = new JButton("<-"); // need to work on this
		c.gridx = 4;
		c.gridy = 6;
		buttonPanel.add(backspaceButton, c);
		backspaceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (equationTextField.getText() != null) {
					String str = equationTextField.getText();
					String result = str.substring(0, str.length() - 1);
					equationTextField.setText(result);
					String equation = equationTextField.getText();
					int answer = evaluateExpression(equation);
					answer2 = answer;
					decLabel.setText(String.valueOf(answer));
					hexaLabel.setText(decToHexaConversion(answer));
					binLabel.setText(decToBinConversion(answer));
					octLabel.setText(decToOctConversion(answer));

				} else
					System.out.println("Nothing to backspace.");
			}
		});
		nineButton = new JButton("9");
		c.gridx = 4;
		c.gridy = 7;
		buttonPanel.add(nineButton, c);
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {
					equationTextField.append("9");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("BYTE")) {
					equationTextField.append("9");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("DWORD")) {
					equationTextField.append("9");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("QWORD")) {
					equationTextField.append("9");
					if (decButton.isSelected())
						setNumberConversionsForLongForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForLongForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForLongForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForLongForBin();
					}
				}
			}
		});

		sixButton = new JButton("6");
		c.gridx = 4;
		c.gridy = 8;
		buttonPanel.add(sixButton, c);
		sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {
					equationTextField.append("6");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("BYTE")) {
					equationTextField.append("6");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("DWORD")) {
					equationTextField.append("6");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("QWORD")) {
					equationTextField.append("6");
					if (decButton.isSelected())
						setNumberConversionsForLongForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForLongForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForLongForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForLongForBin();
					}
				}
			}
		});

		threeButton = new JButton("3");
		c.gridx = 4;
		c.gridy = 9;
		buttonPanel.add(threeButton, c);
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordButton.getText().equals("WORD")) {
					equationTextField.append("3");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("BYTE")) {
					equationTextField.append("3");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("DWORD")) {
					equationTextField.append("3");
					if (decButton.isSelected())
						setNumberConversionsForIntForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForIntForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForIntForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForIntForBin();
					}
				}
				if (wordButton.getText().equals("QWORD")) {
					equationTextField.append("3");
					if (decButton.isSelected())
						setNumberConversionsForLongForDec();
					if (hexaButton.isSelected()) {
						setNumberConversionsForLongForHex();
					}
					if (octButton.isSelected()) {
						setNumberConversionsForLongForOct();
					}
					if (binButton.isSelected()) {
						setNumberConversionsForLongForBin();
					}
				}
			}
		});

		noUseButton = new JButton(".");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 4;
		c.gridy = 10;
		buttonPanel.add(noUseButton, c);

		noUseButton = new JButton("And");
		noUseButton.setForeground(Color.GRAY);
		c.gridx = 5;
		c.gridy = 5;
		buttonPanel.add(noUseButton, c);

		diviButton = new JButton("/");
		c.gridx = 5;
		c.gridy = 6;
		buttonPanel.add(diviButton, c);
		diviButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equationTextField.append("/");
			}
		});

		multButton = new JButton("X");
		c.gridx = 5;
		c.gridy = 7;
		buttonPanel.add(multButton, c);
		multButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equationTextField.append("*");
			}
		});

		subButton = new JButton("-");
		c.gridx = 5;
		c.gridy = 8;
		buttonPanel.add(subButton, c);
		subButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equationTextField.append("-");
			}
		});

		addButton = new JButton("+");
		c.gridx = 5;
		c.gridy = 9;
		buttonPanel.add(addButton, c);
		addButton.addActionListener(this);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equationTextField.append("+");
			}
		});

		equalButton = new JButton("=");
		c.gridx = 5;
		c.gridy = 10;
		buttonPanel.add(equalButton, c);

		equalButton.addActionListener(this);

		add(buttonPanel, BorderLayout.SOUTH);
		add(labelsPanel, BorderLayout.EAST);
		add(titlePanel, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// evaluate word button, changes on click
		if (e.getSource() == wordButton)
			wordButton.setText(setWordButton(wordButton.getText()));

		// manages button and equals to display larger number
		if (decButton.isSelected() == true) {
			hexaButton.setSelected(false);
			binButton.setSelected(false);
			octButton.setSelected(false);
			if (e.getSource() == equalButton) {
				String equation = equationTextField.getText();
				int answer = evaluateExpression(equation);
				answerLabel.setText(String.valueOf(answer));
				decLabel.setText(String.valueOf(answer));
				hexaLabel.setText(decToHexaConversion(answer));
				binLabel.setText(decToBinConversion(answer));
				octLabel.setText(decToOctConversion(answer));
			}
		}
		if (hexaButton.isSelected() == true) {
			decButton.setSelected(false);
			binButton.setSelected(false);
			octButton.setSelected(false);
			if (e.getSource() == equalButton) {
				String equation = equationTextField.getText();
				String answer = hexConv.evaluateExpression(equation);
				answerLabel.setText(answer);
				int decAnswer = hexConv.hexToDecConversion(answer);
				decLabel.setText(String.valueOf(decAnswer));
				hexaLabel.setText(answer);
				binLabel.setText(decToBinConversion(decAnswer));
				octLabel.setText(decToOctConversion(decAnswer));
			}
		}

		if (octButton.isSelected() == true) {
			decButton.setSelected(false);
			binButton.setSelected(false);
			hexaButton.setSelected(false);
			if (e.getSource() == equalButton) {
				String equation = equationTextField.getText();
				String answer = octConv.evaluateExpression(equation);
				answerLabel.setText(answer);
				int decAnswer = octConv.octToDecConversion(answer);
				decLabel.setText(String.valueOf(decAnswer));
				hexaLabel.setText(answer);
				binLabel.setText(decToBinConversion(decAnswer));
				octLabel.setText(decToOctConversion(decAnswer));
			}
		}
		if (binButton.isSelected() == true) {
			decButton.setSelected(false);
			octButton.setSelected(false);
			hexaButton.setSelected(false);
			if (e.getSource() == equalButton) {
				String equation = equationTextField.getText();
				String answer = binConv.evaluateExpression(equation);
				answerLabel.setText(answer);
				int decAnswer = binConv.binToDecConversion(answer);
				decLabel.setText(String.valueOf(decAnswer));
				hexaLabel.setText(answer);
				binLabel.setText(decToBinConversion(decAnswer));
				octLabel.setText(decToOctConversion(decAnswer));
			}
		}

	}

	// cycles through all 4 words
	public String setWordButton(String str) {
		if (str.equalsIgnoreCase("WORD")) {
			return "DWORD";
		}
		if (str.equalsIgnoreCase("DWORD")) {
			return "QWORD";
		}
		if (str.equalsIgnoreCase("QWORD")) {
			return "BYTE";
		}
		if (str.equalsIgnoreCase("BYTE")) {
			return "WORD";
		}

		return "";
	}

	// converts to calculate ranges for numbers
	public String decToHexaConversion(int number) {
		return Integer.toHexString(number);
	}

	public String decToBinConversion(int number) {
		return Integer.toBinaryString(number);
	}

	public String decToOctConversion(int number) {
		return Integer.toOctalString(number);
	}

	public String decToDecConversion(int number) {
		return Integer.toString(number);
	}

	// evaluate the String written by the user
	public Integer evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();

		Stack<Character> operatorStack = new Stack<>();
		expression = insertBlanks(expression);

		String[] tokens = expression.split(" ");

		for (String token : tokens) {
			if (token.length() == 0)
				continue;
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {

				while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'
						|| operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '%')) {
					processAnOperator(operandStack, operatorStack);
				}

				operatorStack.push(token.charAt(0));
			} else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/'
						|| operatorStack.peek() == '%')) {
					processAnOperator(operandStack, operatorStack);
				}

				operatorStack.push(token.charAt(0));
			} else if (token.trim().charAt(0) == '(') {
				operatorStack.push('('); // Push '(' to stack
			} else if (token.trim().charAt(0) == ')') {

				while (operatorStack.peek() != '(') {
					processAnOperator(operandStack, operatorStack);
				}

				operatorStack.pop();
			} else {

				operandStack.push(new Integer(token));
			}
		}

		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}
		return operandStack.pop();
	}

	// calculates

	public void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+')
			operandStack.push(op2 + op1);
		else if (op == '-')
			operandStack.push(op2 - op1);
		else if (op == '*')
			operandStack.push(op2 * op1);
		else if (op == '/')
			operandStack.push(op2 / op1);
		else if (op == '%') {
			operandStack.push(op2 % op1);
		}
	}

	public String insertBlanks(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
					|| s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '%')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}

		return result;
	}

	// constantly updates hexa, dec, bin and oct numbers while user is entering
	// string
	public void setNumberConversionsForIntForDec() {
		String equation = equationTextField.getText();
		int answer = evaluateExpression(equation);
		if (isInRange(answer)) {
			decLabel.setText(String.valueOf(answer));
			hexaLabel.setText(decToHexaConversion(answer));
			binLabel.setText(decToBinConversion(answer));
			octLabel.setText(decToOctConversion(answer));
		} else {
			String str = equationTextField.getText();
			String result = str.substring(0, str.length() - 1);
			equationTextField.setText(result);
		}

	}

	public void setNumberConversionsForLongForDec() {
		String equation = equationTextField.getText();
		long answer = qWordConversion.evaluateExpression(equation);
		if (isInRangeForLong(answer)) {
			decLabel.setText(String.valueOf(answer));
			hexaLabel.setText(qWordConversion.decToHexaConversion(answer));
			binLabel.setText(qWordConversion.decToBinConversion(answer));
			octLabel.setText(qWordConversion.decToOctConversion(answer));
		} else {
			String str = equationTextField.getText();
			String result = str.substring(0, str.length() - 1);
			equationTextField.setText(result);
		}
	}

	public void setNumberConversionsForIntForHex() {
		String equation = equationTextField.getText();
		String answer = hexConv.evaluateExpression(equation);
		int decAnswer = hexConv.hexToDecConversion(answer);
		if (isInRange(decAnswer)) {
			decLabel.setText(String.valueOf(decAnswer));
			hexaLabel.setText(decToHexaConversion(decAnswer));
			binLabel.setText(decToBinConversion(decAnswer));
			octLabel.setText(decToOctConversion(decAnswer));
		} else {
			String str = equationTextField.getText();
			String result = str.substring(0, str.length() - 1);
			equationTextField.setText(result);
		}
	}

	public void setNumberConversionsForIntForOct() {
		String equation = equationTextField.getText();
		String answer = octConv.evaluateExpression(equation);
		int decAnswer = octConv.octToDecConversion(answer);
		if (isInRange(decAnswer)) {
			decLabel.setText(String.valueOf(decAnswer));
			hexaLabel.setText(decToHexaConversion(decAnswer));
			binLabel.setText(decToBinConversion(decAnswer));
			octLabel.setText(decToOctConversion(decAnswer));
		} else {
			String str = equationTextField.getText();
			String result = str.substring(0, str.length() - 1);
			equationTextField.setText(result);
		}
	}

	public void setNumberConversionsForIntForBin() {
		String equation = equationTextField.getText();
		String answer = binConv.evaluateExpression(equation);
		int decAnswer = binConv.binToDecConversion(answer);
		if (isInRange(decAnswer)) {
			decLabel.setText(String.valueOf(decAnswer));
			hexaLabel.setText(decToHexaConversion(decAnswer));
			binLabel.setText(decToBinConversion(decAnswer));
			octLabel.setText(decToOctConversion(decAnswer));
		} else {
			String str = equationTextField.getText();
			String result = str.substring(0, str.length() - 1);
			equationTextField.setText(result);
		}
	}

	///////////////

	public void setNumberConversionsForLongForHex() {
		String equation = equationTextField.getText();
		String answer = hexConv.evaluateExpressionForLong(equation);
		answerLabel.setText(answer);
		long decAnswer = hexConv.hexToDecConversionForLong(answer);
		if (isInRangeForLong(decAnswer)) {
			decLabel.setText(String.valueOf(decAnswer));
			hexaLabel.setText(qWordConversion.decToHexaConversion(decAnswer));
			binLabel.setText(qWordConversion.decToBinConversion(decAnswer));
			octLabel.setText(qWordConversion.decToOctConversion(decAnswer));
		} else {
			String str = equationTextField.getText();
			String result = str.substring(0, str.length() - 1);
			equationTextField.setText(result);
		}

	}

	public void setNumberConversionsForLongForOct() {
		String equation = equationTextField.getText();
		String answer = octConv.evaluateExpressionForLong(equation);
		long decAnswer = octConv.octToDecConversionForLong(answer);
		if (isInRangeForLong(decAnswer)) {
			decLabel.setText(String.valueOf(decAnswer));
			hexaLabel.setText(qWordConversion.decToHexaConversion(decAnswer));
			binLabel.setText(qWordConversion.decToBinConversion(decAnswer));
			octLabel.setText(qWordConversion.decToOctConversion(decAnswer));
		} else {
			String str = equationTextField.getText();
			String result = str.substring(0, str.length() - 1);
			equationTextField.setText(result);
		}
	}

	public void setNumberConversionsForLongForBin() {
		String equation = equationTextField.getText();
		String answer = binConv.evaluateExpressionForLong(equation);
		answerLabel.setText(answer);
		long decAnswer = binConv.binToDecConversionForLong(answer);
		if (isInRangeForLong(decAnswer)) {
			decLabel.setText(String.valueOf(decAnswer));
			hexaLabel.setText(qWordConversion.decToHexaConversion(decAnswer));
			binLabel.setText(qWordConversion.decToBinConversion(decAnswer));
			octLabel.setText(qWordConversion.decToOctConversion(decAnswer));
		} else {
			String str = equationTextField.getText();
			String result = str.substring(0, str.length() - 1);
			equationTextField.setText(result);
		}
	}

	// checks to see if it is in range
	public boolean isInRange(int number) {
		if (wordButton.getText().equals("WORD")) {
			if (number > 32767)
				return false;
		}
		if (wordButton.getText().equals("BYTE")) {
			if (number > 255)
				return false;
		}
		if (wordButton.getText().equals("DWORD")) {
			if (number > 2147483647) {
				return false;
			}
		}

		return true;
	}

	public boolean isInRangeForLong(long number) {
		if (wordButton.getText().equals("QWORD")) {
			if (number > 9223372036854775807L)
				return false;
		}
		return true;
	}

}