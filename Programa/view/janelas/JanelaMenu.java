package view.janelas;

import gerenciamento.MenuBarListener;
import view.janelas.DecoradorJanela;
import view.janelas.JanelaAbstrata;
import view.janelas.JanelaMenuListener;
import javax.swing.*;

//Classe de decoracao de janela. Adiciona a barra de menu no topo da janela.
public class JanelaMenu extends DecoradorJanela
{
    private JMenuBar barra_menu;
    private JMenu arquivo;
    private JMenuItem abrir_item;
    private JMenuItem salvar_item;
    private JMenuItem fechar_item;
    private JMenu ajuda;
    private JMenuItem suporte_item;
    private JMenuItem desenvolvedores_item;
    private JMenuItem sobre_item;
    private JanelaMenuListener listener;

    public JanelaMenu(JanelaAbstrata janela)
    {
        super(janela);
    }

    public void montar()
    {
        listener = new JanelaMenuListener();
        listener.adicionarMenuObservador(new MenuBarListener());
        criarBarraDeMenu();
        super.frame.setJMenuBar(barra_menu);
        super.janela.montar();
    }

    private void criarBarraDeMenu()
    {
        barra_menu = new JMenuBar();
        arquivo = new JMenu("Arquivo");
        abrir_item = new JMenuItem("Abrir"); 
        salvar_item = new JMenuItem("Salvar");
        fechar_item = new JMenuItem("Fechar");
        abrir_item.addActionListener(listener);
        salvar_item.addActionListener(listener);
        fechar_item.addActionListener(listener);
        arquivo.add(abrir_item);
        arquivo.add(salvar_item);
        arquivo.add(fechar_item);
        ajuda = new JMenu("Ajuda");
        suporte_item = new JMenuItem("Suporte"); 
        desenvolvedores_item = new JMenuItem("Desenvolvedores");
        sobre_item = new JMenuItem("Sobre");
        suporte_item.addActionListener(listener);
        desenvolvedores_item.addActionListener(listener);
        sobre_item.addActionListener(listener);
        ajuda.add(suporte_item);
        ajuda.add(desenvolvedores_item);
        ajuda.add(sobre_item);
        barra_menu.add(arquivo);
        barra_menu.add(ajuda);
    }
}