package ua.nure.cs.chumak.usermanagement1.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ua.nure.cs.chumak.usermanagement1.db.DaoFactory;
import ua.nure.cs.chumak.usermanagement1.db.UserDao;
import ua.nure.cs.chumak.usermanagement1.domain.User;
import ua.nure.cs.chumak.usermanagement1.util.Messages;

public class MainFrame extends JFrame {

	private static final int FRAME_HEIGHT = 600;
	private static final int FRAME_WIDTH = 800;
	private JPanel contentPanel;
	private JPanel browsePanel;
	private AddPanel addPanel;
	private EditPanel editPanel;
	private DetailsPanel detailsPanel;
	private DeletePanel deletePanel;
	private UserDao dao;
	private UserTableModel utm;


	public MainFrame() {
		super();
		dao = DaoFactory.getInstance().getUserDao();
		initialize();
		utm = new UserTableModel();
	}
	
	public UserDao getDao() {
		return dao;
	}

	
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle(Messages.getString("MainFrame.user_management1")); //$NON-NLS-1$
		this.setContentPane(getContentPanel());	
	}

	private JPanel getContentPanel() {
		if(contentPanel == null) {
			contentPanel = new JPanel();
			contentPanel.setLayout(new BorderLayout());
			contentPanel.add(getBrowsePanel(), BorderLayout.CENTER);
		}
		return contentPanel;
	}

	private JPanel getBrowsePanel() {
		if (browsePanel == null) {
			browsePanel = new BrowsePanel(this);
		}
		((BrowsePanel) browsePanel).initTable();
		return browsePanel;
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);

	}

	public void showAddPanel() {
		showPanel(getAddPanel());
		
	}
	
	public void showEditPanel(int selectedRow) {
		// TODO Auto-generated method stub
		showPanel(getEditPanel(utm.getValueAt(selectedRow)));
	}
	
	public void showDetailsPanel(int selectedRow) {
		// TODO Auto-generated method stub
		showPanel(getDetailsPanel(utm.getValueAt(selectedRow)));
	}
	
	public void showDeletePanel(int selectedRow) {
		// TODO Auto-generated method stub
		showPanel(getDeletePanel(utm.getValueAt(selectedRow)));
	}

	private void showPanel(JPanel panel) {
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		panel.repaint();
		
	}

	private AddPanel getAddPanel() {
		if(addPanel == null) {
			addPanel = new AddPanel(this);
		}
		return addPanel; 
	}
	
	private EditPanel getEditPanel(User user) {
		// TODO Auto-generated method stub
		if (editPanel == null) {
			editPanel = new EditPanel(this, user);
		}
		return editPanel;
	}
	
	private DetailsPanel getDetailsPanel(User user) {
		// TODO Auto-generated method stub
		if (detailsPanel == null) {
			detailsPanel = new DetailsPanel(this, user);
		}
		return detailsPanel;
	}
	
	private DeletePanel getDeletePanel(User user) {
		// TODO Auto-generated method stub
		if (deletePanel == null) {
			deletePanel = new DeletePanel(this, user);
		}
		return deletePanel;
	}
	
	public void showBrowsePanel() {
		showPanel(getBrowsePanel());
	}

}
