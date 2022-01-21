package MainOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.annotation.Inherited;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class App implements ActionListener {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;

    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuAnalyze;

    JMenuItem INew, IOpen, ISave, ISaveAs, IClose, IExit;
    JMenuItem IFind, IReplace, IReplaceAll;
    JMenuItem IWords, ICharacters, ICharactersNoSpaces, IParagraphs;

    JSlider slider;


    FunctionFile file = new FunctionFile(this);
    FunctionEdit edit = new FunctionEdit(this);
    FunctionAnalyze analyze = new FunctionAnalyze(this);

    public App() {
        createWindow();
        createTextArea();
        createMenuBar();

        window.setVisible(true);
    }

    private void createWindow() {
        window = new JFrame("Untitled");
        window.setSize(780, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File      ");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit      ");
        menuBar.add(menuEdit);

        menuAnalyze = new JMenu("Analyze        ");
        menuBar.add(menuAnalyze);


        createFileMenu();
        createEditMenu();
        createAnalyzeMenu();


        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        menuBar.add(slider);


        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(slider.getValueIsAdjusting()) {
                    textArea.setFont(new Font(
                            textArea.getFont().getFontName(),
                            textArea.getFont().getStyle(),
                            slider.getValue()));
                }
            }
        });

        scrollPane.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent evt) {
                if (evt.isControlDown()) {
                    textArea.setFont(new Font(textArea.getFont().getFontName(), textArea.getFont().getStyle(),
                            evt.getUnitsToScroll() > 0 ? textArea.getFont().getSize() - 2
                                    : textArea.getFont().getSize() + 2));
//                    int temp = slider.getValue();
//                    slider.setValue(temp + 2);
                }
            }
        });

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                file.exit();
            }
        });
    }

    public void createFileMenu() {
        INew = new JMenuItem("New");
        INew.addActionListener(this);
        INew.setActionCommand("New");
        menuFile.add(INew);

        IOpen = new JMenuItem("Open");
        IOpen.addActionListener(this);
        IOpen.setActionCommand("Open");
        menuFile.add(IOpen);

        ISave = new JMenuItem("Save");
        ISave.addActionListener(this);
        ISave.setActionCommand("Save");
        menuFile.add(ISave);

        ISaveAs = new JMenuItem("Save as");
        ISaveAs.addActionListener(this);
        ISaveAs.setActionCommand("SaveAs");
        menuFile.add(ISaveAs);

        IClose = new JMenuItem("Close");
        menuFile.add(IClose);

        IExit = new JMenuItem("Exit");
        IExit.addActionListener(this);
        IExit.setActionCommand("Exit");
        menuFile.add(IExit);
    }

    public void createEditMenu(){
        IFind = new JMenuItem("Find");
        IFind.addActionListener(this);
        IFind.setActionCommand("Find");
        menuEdit.add(IFind);

        IReplace = new JMenuItem("Replace");
        IReplace.addActionListener(this);
        IReplace.setActionCommand("Replace");
        menuEdit.add(IReplace);

        IReplaceAll = new JMenuItem("Replace all");
        IReplaceAll.addActionListener(this);
        IReplaceAll.setActionCommand("Replace all");
        menuEdit.add(IReplaceAll);
    }

    public void createAnalyzeMenu() {
        IWords = new JMenuItem("Words");
        IWords.addActionListener(this);
        IWords.setActionCommand("Words");
        menuAnalyze.add(IWords);

        ICharacters = new JMenuItem("Characters");
        ICharacters.addActionListener(this);
        ICharacters.setActionCommand("Characters");
        menuAnalyze.add(ICharacters);

        ICharactersNoSpaces = new JMenuItem("Characters (no spaces)");
        ICharactersNoSpaces.addActionListener(this);
        ICharactersNoSpaces.setActionCommand("CharactersNoSpaces");
        menuAnalyze.add(ICharactersNoSpaces);

        IParagraphs = new JMenuItem("Paragraphs");
        IParagraphs.addActionListener(this);
        IParagraphs.setActionCommand("Paragraphs");
        menuAnalyze.add(IParagraphs);
    }

    public static void main(String[] args) {
        new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            case "New" -> file.newFile();
            case "Open" -> file.open();
            case "SaveAs" -> file.saveAs();
            case "Save" -> file.save();
            case "Exit" -> file.exit();
            case "Close" -> file.close();

            case "Find" -> edit.find();
            case "Replace" -> edit.replace();
            case "Replace All" -> edit.replaceAll();

            case "Words" -> analyze.words();
            case "Characters" -> analyze.characters();
            case "CharactersNoSpaces" -> analyze.charactersNoSpaces();
            case "Paragraphs" -> analyze.paragraphs();
        }
    }
}