
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;



/**
 * @author KingViker qq：413041153
 */
public class GeneratorJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new GeneratorJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
	}

	
	private JTextField tableNameInput;
	private JTextField modulNameInput;
	private JTextField classNameInput;
	private JTextField datasourceNameInput;
	private JComboBox idStrategyInput;
	private JTextArea messageArea;
	private JButton generatorBtn;
	private PrintStream ps;
	public GeneratorJFrame() {
		super("rapid-genterator by KingViker");
		initComponents();
	}
	private void initComponents() {
		Font f = new Font("宋体",Font.PLAIN,15); 

		UIManager.put("Label.font",f); 
		UIManager.put("Button.font",f); 

		Container contentPane = getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
//		outRootFunctionInput = new JTextField(GeneratorProperties.getProperty("outRootFunction"));
//		JLabel outRootFunction = new JLabel("生成后台代码路径：");
//		outRootFunction.setBounds(20,10,180,25);
//		panel.add(outRootFunction);
//		outRootFunctionInput.setBounds(210,10,160,25);
//		panel.add(outRootFunctionInput);
//		
//		outRootJspInput = new JTextField(GeneratorProperties.getProperty("outRootJsp"));
//		JLabel outRootJsp = new JLabel("生成jsp路径：");
//		outRootJsp.setBounds(20,40,180,25);
//		panel.add(outRootJsp);
//		outRootJspInput.setBounds(210,40,160,25);
//		panel.add(outRootJspInput);
		
		tableNameInput = new JTextField();
		JLabel tableName = new JLabel("数据库表名称：");
		tableName.setBounds(20, 10, 180, 25);
		panel.add(tableName);
		tableNameInput.setBounds(210, 10, 160, 25);
		tableNameInput.setText("tbl_");
		panel.add(tableNameInput);
		
		modulNameInput = new JTextField();
		JLabel modulName = new JLabel("模块名称：");
		modulName.setBounds(20, 40, 180, 25);
		panel.add(modulName);
		modulNameInput.setBounds(210, 40, 160, 25);
		panel.add(modulNameInput);
		
		classNameInput = new JTextField();
		JLabel className = new JLabel("数据库表名称映射的类名：");
		className.setBounds(20, 70, 180, 25);
		panel.add(className);
		classNameInput.setBounds(210, 70, 160, 25);
		panel.add(classNameInput);

		datasourceNameInput = new JTextField();
		JLabel datasourceName = new JLabel("数据源代号(如one,two)：");
		datasourceName.setBounds(20, 100, 180, 25);
		panel.add(datasourceName);
		datasourceNameInput.setText("one");
		datasourceNameInput.setBounds(210, 100, 160, 25);
		panel.add(datasourceNameInput);
		
		String[] str = {"自增","手工"};
		idStrategyInput = new JComboBox(str);
		JLabel hasPermission = new JLabel("ID策略：");
		hasPermission.setBounds(20, 130, 180, 25);
		panel.add(hasPermission);
		idStrategyInput.setBounds(210, 130, 160, 25);
		panel.add(idStrategyInput);
		
		//信息展示窗口
		messageArea = new JTextArea();
		messageArea.setBounds(20, 200, 355, 150);
		JScrollPane jsp = new JScrollPane(messageArea);
		jsp.setBounds(20,200,355,150);
		panel.add(jsp);
		//将项目system.out指定到messageArea，这样项目中的打印功能，都会打印到messageArea中
		ps = new PrintStream(System.out) {
		      public void println(String x) {
		    	  messageArea.append(x + "\n");
		      }
		    };
		System.setOut(ps);
		    
		generatorBtn = new JButton();
		generatorBtn.setText("生成");
		generatorBtn.setBounds(100, 160, 80, 30);
		generatorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                generatorBtnActionPerformed(evt);
            }
        });
		
		panel.add(generatorBtn);
		
		JButton  exitBtn= new JButton("退出");
		exitBtn.setBounds(220, 160, 80, 30);
		exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               System.exit(0);
            }
        });
		panel.add(exitBtn);
		
		contentPane.add(panel);
		double   width   =   Toolkit.getDefaultToolkit().getScreenSize().getWidth(); 
        double   height   =   Toolkit.getDefaultToolkit().getScreenSize().getHeight(); 
        this.setLocation((int)(width - this.getWidth())/2-175,(int)(height - this.getHeight())/2-150); 
		this.setSize(400,390);
		this.setVisible(true);
		this.setResizable(false);

	}
	private void generatorBtnActionPerformed(ActionEvent evt){
		if(StringUtils.isBlank(tableNameInput.getText())){
			JOptionPane.showMessageDialog(this, "请输入表名称！");
			return;
		}
		if(StringUtils.isBlank(modulNameInput.getText())){
			String tableNamePrefix = GeneratorProperties.getProperty("tableRemovePrefixes");
			modulNameInput.setText(tableNameInput.getText().substring(tableNamePrefix.length()).toLowerCase());
		}
		if(StringUtils.isBlank(classNameInput.getText())){
			String tableNamePrefix = GeneratorProperties.getProperty("tableRemovePrefixes");
			classNameInput.setText(StringUtils.capitalize(tableNameInput.getText().substring(tableNamePrefix.length()).toLowerCase()));
		}
        if(StringUtils.isBlank(datasourceNameInput.getText())){
            datasourceNameInput.setText("one");
        }
		GeneratorFacade facade = new GeneratorFacade();
		System.setProperty("modulName", modulNameInput.getText().trim());
		System.setProperty("className", classNameInput.getText().trim());
		System.setProperty("datasourceName", datasourceNameInput.getText().trim());
		System.setProperty("idStrategy",(String)idStrategyInput.getSelectedItem());
		
		try {
			String jdbcDriver = GeneratorProperties.getProperty("jdbc.driver");
			if(jdbcDriver.equals("oracle.jdbc.driver.OracleDriver")){
                System.setProperty("databaseType", "oracle");
				//facade.generateByTable(tableNameInput.getText().trim(),getTemplateRootDir()+File.separator+"noPermission_oracle");
			}else if(jdbcDriver.equals("com.mysql.jdbc.Driver")){
                System.setProperty("databaseType", "mysql");
			}


			//清空输出目录
			FileUtils.cleanDirectory(new File(GeneratorProperties.getProperty("outRootFunction")));

			//根据模板生成代码
            facade.generateByTable(tableNameInput.getText().trim(),getTemplateRootDir()+File.separator+"noPermission");

			//对jsp中的特殊字符进行替换,这里这么做事为了区分jsp变量和freemarker变量，所以在生成文件后要将其替换回正确的内容：
			// $\{ --> ${
			fixJsp(GeneratorProperties.getProperty("outRootFunction") +File.separator+modulNameInput.getText().trim()+File.separator+"jsp"+File.separator+classNameInput.getText().trim()+"_list.jsp");
			fixJsp(GeneratorProperties.getProperty("outRootFunction") +File.separator+modulNameInput.getText().trim()+File.separator+"jsp"+File.separator+classNameInput.getText().trim()+"_edit.jsp");

			fixJsp(GeneratorProperties.getProperty("outRootFunction") +File.separator+modulNameInput.getText().trim()+File.separator+"html"+File.separator+classNameInput.getText().trim()+"_list.html");
			fixJsp(GeneratorProperties.getProperty("outRootFunction") +File.separator+modulNameInput.getText().trim()+File.separator+"html"+File.separator+classNameInput.getText().trim()+"_edit.html");
			messageArea.append("Generate Successfully!");

			//copyFileToProject();

			JOptionPane.showMessageDialog(this, "代码已生成！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 移动到指定的项目目录
	 * @throws IOException
	 */
	private void copyFileToProject() throws IOException {

		String outRootProject = GeneratorProperties.getProperty("outRootProject");
		if(outRootProject!=null) {

			String outRoot = GeneratorProperties.getProperty("outRootFunction") + modulNameInput.getText().trim() + File.separator;
			String listJspFile = outRoot + "jsp" + File.separator + classNameInput.getText().trim() + "_list.jsp";
			String editJspFile = outRoot + "jsp" + File.separator + classNameInput.getText().trim() + "_edit.jsp";
			String modelFile = outRoot + "model" + File.separator + classNameInput.getText().trim() + ".java";
			String controllerFile = outRoot + "controller" + File.separator + classNameInput.getText().trim() + "Controller.java";
			String serviceFile = outRoot + "service" + File.separator + "I" + classNameInput.getText().trim() + "Service.java";
			String serviceImplFile = outRoot + "service" + File.separator + "impl" + File.separator + classNameInput.getText().trim() + "ServiceImpl.java";
			String daoFile = outRoot + "dao" + File.separator + "jpa" + File.separator + classNameInput.getText().trim() + "JpaRepository.java";

			String messagesFile = outRoot + "view" + File.separator + "messages_" + classNameInput.getText().trim() + ".properties";
			String viewsFile = outRoot + "view" + File.separator + "views_" + classNameInput.getText().trim() + ".properties";


			String listHtmlFile = outRoot + "html" + File.separator + classNameInput.getText().trim() + "_list.html";
			String editHtmlFile = outRoot + "html" + File.separator + classNameInput.getText().trim() + "_edit.html";


			String outBeanDir = outRootProject+GeneratorProperties.getProperty("outBeanDir")+modulNameInput.getText().trim();
			outBeanDir = outBeanDir.replace("#datasource#",datasourceNameInput.getText().trim());
			String outDaoDir = outRootProject+GeneratorProperties.getProperty("outDaoDir")+datasourceNameInput.getText().trim()+File.separator+modulNameInput.getText().trim();
			String outServiceDir = outRootProject+GeneratorProperties.getProperty("outServiceDir")+modulNameInput.getText().trim();
			String outServiceImplDir = outRootProject+GeneratorProperties.getProperty("outServiceImplDir")+modulNameInput.getText().trim();
			String outControllerDir = outRootProject+GeneratorProperties.getProperty("outControllerDir")+modulNameInput.getText().trim();
			String outJspDir = outRootProject+GeneratorProperties.getProperty("outJspDir")+modulNameInput.getText().trim();
			String outViewsDir = outRootProject+GeneratorProperties.getProperty("outViewsDir")+modulNameInput.getText().trim();
			String outMessagesDir = outRootProject+GeneratorProperties.getProperty("outMessagesDir")+modulNameInput.getText().trim();


			String outHtmlDir = outRootProject+GeneratorProperties.getProperty("outHtmlDir")+modulNameInput.getText().trim();





			FileUtils.copyFileToDirectory(new File(listJspFile),new File(outJspDir));
			FileUtils.copyFileToDirectory(new File(editJspFile),new File(outJspDir));
			FileUtils.copyFileToDirectory(new File(modelFile),new File(outBeanDir));
			FileUtils.copyFileToDirectory(new File(controllerFile),new File(outControllerDir));
			FileUtils.copyFileToDirectory(new File(serviceFile),new File(outServiceDir));
			FileUtils.copyFileToDirectory(new File(serviceImplFile),new File(outServiceImplDir));
			FileUtils.copyFileToDirectory(new File(daoFile),new File(outDaoDir));
			FileUtils.copyFileToDirectory(new File(messagesFile),new File(outMessagesDir));
			FileUtils.copyFileToDirectory(new File(viewsFile),new File(outViewsDir));

			FileUtils.copyFileToDirectory(new File(listHtmlFile),new File(outHtmlDir));
			FileUtils.copyFileToDirectory(new File(editHtmlFile),new File(outHtmlDir));




		}
	}
	private  String getTemplateRootDir() {
		return System.getProperty("templateRootDir", "template");
	}
	public PrintStream getPs() {
	      return ps;
    }
	
	public void fixJsp(String filePath) throws Exception{
		BufferedReader jsp = null;
		BufferedWriter bw = null;
		try {
			jsp = new BufferedReader(new FileReader(filePath));
			String line=null;
			StringBuffer buf = new StringBuffer();  
			while((line = jsp.readLine()) != null){
				//$\\{ --> \\${，第一个\是转意，实际上是$\{ --> \${
				buf.append(line.replaceAll("\\u0024\\\\\\u007B", "\\${").replaceAll("\\u0023\\\\\\u007B", "\\#{")).append("\n");
			}
			bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(buf.toString());
		} catch (Exception e) {
			throw e;
		}finally{
			 // 关闭流  
            if (jsp != null) {  
                try {  
                	jsp.close();  
                } catch (IOException e) {  
                	jsp = null;  
                }  
            }  
            if (bw != null) {  
            	try {  
            		bw.close();  
            	} catch (IOException e) {  
            		bw = null;  
            	}  
            }  
		}
		
		
	}
}
