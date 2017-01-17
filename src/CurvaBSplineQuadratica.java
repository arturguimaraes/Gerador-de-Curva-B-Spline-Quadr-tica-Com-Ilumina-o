import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * @author Artur Guimarães
 */
public class CurvaBSplineQuadratica extends javax.swing.JFrame {
    
// <editor-fold defaultstate="collapsed" desc="DECLARAÇÃO DE VARIÁVEIS">
    private final int actualScreenLimitX = 600, actualScreenLimitY = 600; 
    private int screenLimitX = 600, screenLimitY = 600;
    private float proportionX = 1, proportionY = 1;
    private boolean isPointing = false; 
    private PointDouble3D biggestDistancePoint1, biggestDistancePoint2;
    private PointList pointList = new PointList();
    ArrayList savedPointLists = new ArrayList();
    PointDouble3D[] pointVectorSurfacePoints, deslocatedPointVectorSurfacePoints;
    PointDouble3D[] globalPointVector, globalDeslocatedPointVector;
    DataStructure estruturaDeDadosDaSuperficie;
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="INICIALIZAÇÃO">
    public CurvaBSplineQuadratica() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        pnScreen = new java.awt.Panel();
        lbScreenMinY = new javax.swing.JLabel();
        lbScreenMaxY = new javax.swing.JLabel();
        lbScreenMinX = new javax.swing.JLabel();
        lbScreenMaxX = new javax.swing.JLabel();
        tpOptionsPanel = new javax.swing.JTabbedPane();
        pnScreenConfig = new javax.swing.JPanel();
        lbScreenLimitX = new javax.swing.JLabel();
        tfScreenLimitY = new javax.swing.JTextField();
        tfScreenLimitX = new javax.swing.JTextField();
        btScreenLimit = new javax.swing.JButton();
        pnPoints = new javax.swing.JPanel();
        btEnablePointing = new javax.swing.JToggleButton();
        btClearPointArray = new javax.swing.JButton();
        lbSavedListPoints = new javax.swing.JLabel();
        spSavedPointLists = new javax.swing.JScrollPane();
        lsSavedPointLists = new javax.swing.JList();
        btSelectPointList = new javax.swing.JButton();
        btPrintPoints = new javax.swing.JButton();
        btEditPoints = new javax.swing.JButton();
        btSavePointList = new javax.swing.JButton();
        btDeletePointList = new javax.swing.JButton();
        btSaveFileList = new javax.swing.JButton();
        btLoadFileList = new javax.swing.JButton();
        btClearAllSavedPointLists = new javax.swing.JButton();
        pnFunctions = new javax.swing.JPanel();
        pnBSpline = new javax.swing.JPanel();
        btConnectPoints = new javax.swing.JButton();
        btDrawBSpline = new javax.swing.JButton();
        btDrawBiggestDistance = new javax.swing.JButton();
        btPaintPoints = new javax.swing.JButton();
        btClearScreen = new javax.swing.JButton();
        pnSurface = new javax.swing.JPanel();
        btLight = new javax.swing.JButton();
        btSurface = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btDataStructure = new javax.swing.JButton();
        btDrawEdges = new javax.swing.JButton();
        btDrawVertexes = new javax.swing.JButton();
        btDrawFaces = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pnTests = new javax.swing.JPanel();
        btTest1 = new javax.swing.JButton();
        btTest2 = new javax.swing.JButton();
        btTest4 = new javax.swing.JButton();
        btTest3 = new javax.swing.JButton();
        btDataStructure2 = new javax.swing.JButton();
        btSurface2 = new javax.swing.JButton();
        btLight2 = new javax.swing.JButton();
        btClearScreen2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        spConsole = new javax.swing.JScrollPane();
        taConsole = new javax.swing.JTextArea();
        btClearConsole = new javax.swing.JButton();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Curva B-Spline Quadrática");

        pnScreen.setBackground(new java.awt.Color(0, 0, 0));
        pnScreen.setPreferredSize(new java.awt.Dimension(600, 600));
        pnScreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnScreenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnScreenLayout = new javax.swing.GroupLayout(pnScreen);
        pnScreen.setLayout(pnScreenLayout);
        pnScreenLayout.setHorizontalGroup(
            pnScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        pnScreenLayout.setVerticalGroup(
            pnScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        lbScreenMinY.setText("0");

        lbScreenMaxY.setText("600");

        lbScreenMinX.setText("0");

        lbScreenMaxX.setText("600");

        tpOptionsPanel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        pnScreenConfig.setPreferredSize(new java.awt.Dimension(250, 160));

        lbScreenLimitX.setText("X");

        tfScreenLimitY.setText("600");

        tfScreenLimitX.setText("600");

        btScreenLimit.setText("Configurar");
        btScreenLimit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btScreenLimitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnScreenConfigLayout = new javax.swing.GroupLayout(pnScreenConfig);
        pnScreenConfig.setLayout(pnScreenConfigLayout);
        pnScreenConfigLayout.setHorizontalGroup(
            pnScreenConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnScreenConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnScreenConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btScreenLimit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnScreenConfigLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(tfScreenLimitX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbScreenLimitX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfScreenLimitY, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 93, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnScreenConfigLayout.setVerticalGroup(
            pnScreenConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnScreenConfigLayout.createSequentialGroup()
                .addGroup(pnScreenConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfScreenLimitX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbScreenLimitX)
                    .addComponent(tfScreenLimitY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btScreenLimit)
                .addContainerGap(387, Short.MAX_VALUE))
        );

        tpOptionsPanel.addTab("Tela", pnScreenConfig);

        pnPoints.setPreferredSize(new java.awt.Dimension(250, 280));

        btEnablePointing.setText("Ativar Clique para Criar Pontos");
        btEnablePointing.setPreferredSize(new java.awt.Dimension(185, 25));
        btEnablePointing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEnablePointingMouseClicked(evt);
            }
        });

        btClearPointArray.setText("Limpar Lista de Pontos");
        btClearPointArray.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClearPointArrayMouseClicked(evt);
            }
        });

        lbSavedListPoints.setText("Listas de pontos salvas:");

        lsSavedPointLists.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        spSavedPointLists.setViewportView(lsSavedPointLists);

        btSelectPointList.setText("Selecionar Lista de Pointos");
        btSelectPointList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSelectPointListMouseClicked(evt);
            }
        });

        btPrintPoints.setText("Listar Pontos");
        btPrintPoints.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPrintPointsMouseClicked(evt);
            }
        });

        btEditPoints.setText("Editar Pontos");
        btEditPoints.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEditPointsMouseClicked(evt);
            }
        });

        btSavePointList.setText("Salvar Lista de Pontos");
        btSavePointList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSavePointListMouseClicked(evt);
            }
        });

        btDeletePointList.setText("Deletar Lista de Pontos");
        btDeletePointList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDeletePointListMouseClicked(evt);
            }
        });

        btSaveFileList.setText("Salvar Lista em Arquivo");
        btSaveFileList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSaveFileListMouseClicked(evt);
            }
        });

        btLoadFileList.setText("Carregar Lista de Arquivo");
        btLoadFileList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLoadFileListMouseClicked(evt);
            }
        });

        btClearAllSavedPointLists.setText("Limpar todas as listas salvas");
        btClearAllSavedPointLists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClearAllSavedPointListsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnPointsLayout = new javax.swing.GroupLayout(pnPoints);
        pnPoints.setLayout(pnPointsLayout);
        pnPointsLayout.setHorizontalGroup(
            pnPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPointsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEnablePointing, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(btClearPointArray, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnPointsLayout.createSequentialGroup()
                        .addComponent(lbSavedListPoints)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spSavedPointLists, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(btSelectPointList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(btPrintPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSavePointList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDeletePointList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSaveFileList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLoadFileList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btClearAllSavedPointLists, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnPointsLayout.setVerticalGroup(
            pnPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPointsLayout.createSequentialGroup()
                .addComponent(btEnablePointing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btPrintPoints)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditPoints)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btClearPointArray)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSavePointList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSavedListPoints)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spSavedPointLists, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSelectPointList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDeletePointList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSaveFileList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLoadFileList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btClearAllSavedPointLists)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        tpOptionsPanel.addTab("Lista de Pontos", pnPoints);

        pnFunctions.setPreferredSize(new java.awt.Dimension(250, 330));

        pnBSpline.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "B-Spline Quadrática"));

        btConnectPoints.setText("Conectar Pontos (Control Graph)");
        btConnectPoints.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConnectPointsMouseClicked(evt);
            }
        });

        btDrawBSpline.setText("Desenhar curva B-Spline Quadrática");
        btDrawBSpline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDrawBSplineMouseClicked(evt);
            }
        });

        btDrawBiggestDistance.setText("Desenhar maior distância entre 2 PCs");
        btDrawBiggestDistance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDrawBiggestDistanceMouseClicked(evt);
            }
        });

        btPaintPoints.setText("Desenhar Pontos");
        btPaintPoints.setPreferredSize(new java.awt.Dimension(185, 25));
        btPaintPoints.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPaintPointsMouseClicked(evt);
            }
        });

        btClearScreen.setText("Limpar Tela");
        btClearScreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClearScreenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnBSplineLayout = new javax.swing.GroupLayout(pnBSpline);
        pnBSpline.setLayout(pnBSplineLayout);
        pnBSplineLayout.setHorizontalGroup(
            pnBSplineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBSplineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBSplineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btConnectPoints, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(btClearScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btPaintPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDrawBiggestDistance, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(btDrawBSpline, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnBSplineLayout.setVerticalGroup(
            pnBSplineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBSplineLayout.createSequentialGroup()
                .addComponent(btConnectPoints)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDrawBSpline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDrawBiggestDistance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPaintPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btClearScreen))
        );

        pnSurface.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Surperfície"));

        btLight.setText("Aplicar Iluminação");
        btLight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLightMouseClicked(evt);
            }
        });

        btSurface.setText("Desenhar Superfície");
        btSurface.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSurfaceMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnSurfaceLayout = new javax.swing.GroupLayout(pnSurface);
        pnSurface.setLayout(pnSurfaceLayout);
        pnSurfaceLayout.setHorizontalGroup(
            pnSurfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSurfaceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSurfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSurface, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(btLight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnSurfaceLayout.setVerticalGroup(
            pnSurfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSurfaceLayout.createSequentialGroup()
                .addComponent(btSurface)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLight)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Estrutura de Dados"));

        btDataStructure.setText("Construir Estrutura de Dados");
        btDataStructure.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDataStructureMouseClicked(evt);
            }
        });

        btDrawEdges.setText("Desenhar Arestas");
        btDrawEdges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDrawEdgesMouseClicked(evt);
            }
        });

        btDrawVertexes.setText("Desenhar Vértices");
        btDrawVertexes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDrawVertexesMouseClicked(evt);
            }
        });

        btDrawFaces.setText("Desenhar Faces");
        btDrawFaces.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDrawFacesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDataStructure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDrawEdges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDrawVertexes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDrawFaces, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btDataStructure)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDrawVertexes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDrawEdges)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDrawFaces))
        );

        javax.swing.GroupLayout pnFunctionsLayout = new javax.swing.GroupLayout(pnFunctions);
        pnFunctions.setLayout(pnFunctionsLayout);
        pnFunctionsLayout.setHorizontalGroup(
            pnFunctionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFunctionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFunctionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnBSpline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnSurface, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnFunctionsLayout.setVerticalGroup(
            pnFunctionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFunctionsLayout.createSequentialGroup()
                .addComponent(pnBSpline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnSurface, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );

        tpOptionsPanel.addTab("Funções", pnFunctions);

        pnTests.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Testes Automáticos"));

        btTest1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btTest1.setForeground(new java.awt.Color(0, 153, 0));
        btTest1.setText("Debug - \"teste1.txt\"");
        btTest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTest1MouseClicked(evt);
            }
        });

        btTest2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btTest2.setForeground(new java.awt.Color(0, 153, 0));
        btTest2.setText("Debug - \"teste2.txt\"");
        btTest2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTest2MouseClicked(evt);
            }
        });

        btTest4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btTest4.setForeground(new java.awt.Color(0, 153, 0));
        btTest4.setText("Debug - \"teste4.txt\"");
        btTest4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTest4MouseClicked(evt);
            }
        });

        btTest3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btTest3.setForeground(new java.awt.Color(0, 153, 0));
        btTest3.setText("Debug - \"teste3.txt\"");
        btTest3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTest3MouseClicked(evt);
            }
        });

        btDataStructure2.setText("Construir Estrutura de Dados");
        btDataStructure2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDataStructure2MouseClicked(evt);
            }
        });

        btSurface2.setText("Desenhar Superfície");
        btSurface2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSurface2MouseClicked(evt);
            }
        });

        btLight2.setText("Aplicar Iluminação");
        btLight2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLight2MouseClicked(evt);
            }
        });

        btClearScreen2.setText("Limpar Tela");
        btClearScreen2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClearScreen2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnTestsLayout = new javax.swing.GroupLayout(pnTests);
        pnTests.setLayout(pnTestsLayout);
        pnTestsLayout.setHorizontalGroup(
            pnTestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTestsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btTest1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btTest2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btTest4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btTest3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDataStructure2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(btSurface2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLight2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btClearScreen2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTestsLayout.setVerticalGroup(
            pnTestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTestsLayout.createSequentialGroup()
                .addComponent(btTest1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTest2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTest3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTest4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSurface2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDataStructure2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLight2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btClearScreen2))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnTests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 189, Short.MAX_VALUE))
        );

        tpOptionsPanel.addTab("Testes", jPanel1);

        tpOptionsPanel.setSelectedIndex(1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Mensagens"));

        taConsole.setEditable(false);
        taConsole.setColumns(20);
        taConsole.setLineWrap(true);
        taConsole.setRows(7);
        taConsole.setToolTipText("");
        taConsole.setWrapStyleWord(true);
        taConsole.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        taConsole.setMaximumSize(new java.awt.Dimension(160, 120));
        taConsole.setName(""); // NOI18N
        spConsole.setViewportView(taConsole);

        btClearConsole.setText("Limpar mensagens");
        btClearConsole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClearConsoleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btClearConsole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spConsole))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btClearConsole))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbScreenMaxY)
                    .addComponent(lbScreenMinY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbScreenMinX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbScreenMaxX)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tpOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbScreenMaxY)
                        .addGap(568, 568, 568)
                        .addComponent(lbScreenMinY))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbScreenMaxX)
                            .addComponent(lbScreenMinX)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tpOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void initiate() {
        setVisible(true);
        taConsole.append("Bem-vindo!");
        clearSavedPointLists();
        lsSavedPointLists.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);        
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="MÉTODOS DE LÓGICA">    
    private int getInX(int x) {
        return Math.round(x * proportionX);
    }
    
    private int getInY(int y) {
        return Math.round(y * proportionY);
    }
    
    private int getInInvertedY(int y) {
        return Math.round(screenLimitY - (y * proportionY));
    }
    
    private int getOutX(int x) {
        return Math.round(x * (1/proportionX));
    }
    
    private double getOutDoubleX(double x) {
        return x * (1/proportionX);
    }
    
    private int getOutY(int y) {
        return Math.round(y * (1/proportionY));
    }
    
    private double getOutDoubleY(double y) {
        return y * (1/proportionY);
    }
    
    private int getOutInvertedY(int y) {
        return Math.round((screenLimitY - y) * (1/proportionY));
    }
    
    private double getOutDoubleInvertedY(double y) {
        return (screenLimitY - y) * (1/proportionY);
    }
    
    private Point3D getPointIn (Point3D point) {
        return new Point3D(getInX(point.x), getInY(point.y), point.z);
    }
    
    private Point3D getPointInInverted (Point3D point) {
        return new Point3D(getInX(point.x), getInInvertedY(point.y), point.z);
    }
    
    private Point3D getPointOut (Point3D point) {
        return new Point3D(getOutX(point.x), getOutY(point.y), point.z);
    }
    
    private Point3D getPointOutInverted (Point3D point) {
        return new Point3D(getOutX(point.x), getOutInvertedY(point.y), point.z);
    }
    
    private Point3D getPointOutInverted (PointDouble3D point) {
        return new Point3D(getOutX((int)Math.round(point.x)), getOutInvertedY((int)Math.round(point.y)), point.z);
    }
    
    private PointDouble3D getPointDoubleOutInverted (PointDouble3D point) {
        return new PointDouble3D(getOutDoubleX(point.x), getOutDoubleInvertedY(point.y), point.z);
    }
    
    private Point3D[] editPoint() {
        PointOption[] pointOptions = pointList.getPointOptionArray();
        Point3D newPoint = new Point3D(-1,-1);
        
        PointOption pointOption = (PointOption) JOptionPane.showInputDialog(null,
            "Selecione o ponto que deseja editar","Selecionar ponto",
            JOptionPane.PLAIN_MESSAGE,null,pointOptions,0);
        
        if (pointOption == null)
            return null;
        
        while(newPoint.x < 0 || newPoint.x > screenLimitX || newPoint.y < 0 || newPoint.y > screenLimitY) {
            String x = (String) JOptionPane.showInputDialog(null,
                    String.format("O ponto a ser modificado é: %s\nInforme o novo X (Window máx. %d):", pointOption.toString(), screenLimitX),
                    "Informe o X do ponto", JOptionPane.PLAIN_MESSAGE, null, null, pointOption.x);
            
            if(x == null)
                return null;
            else
                newPoint.x = Integer.parseInt(x);
            
            String y = (String) JOptionPane.showInputDialog(null,
                    String.format("O ponto a ser modificado é: %s\nInforme o novo Y (Window máx. %d):", pointOption.toString(), screenLimitY),
                    "Informe o Y do ponto", JOptionPane.PLAIN_MESSAGE, null, null, pointOption.y);
            if(y == null)
                return null;
            else
                newPoint.y = Integer.parseInt(y);
        }
  
        pointList = changePoint(newPoint, pointOption.index);
        
        Point3D[] result = new Point3D[2];
        result[0] = pointOption.getPoint();
        result[1] = newPoint;
        return result;
    }
    
    private PointList changePoint(Point3D newPoint, int index) {
        PointList newPointList = new PointList();
        PointList pointer = pointList.getFirst();
        
        int position = 0;
        while(position < pointList.pointCount()) {
            if(position != index)
                newPointList = new PointList(newPointList, pointer.point);
            else
                newPointList = new PointList(newPointList, newPoint);
            pointer = pointer.son;
            position++;
        }
        
        return newPointList;
    }
    
    private void clearSavedPointLists() {
        lsSavedPointLists.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            @Override
            public int getSize() { return strings.length; }
            @Override
            public Object getElementAt(int i) { return strings[i]; }
        });
    }
    
    private void savePointList() {
        savedPointLists.add(pointList);
        refreshSavedPointLists();
    }
    
    private void savePointListToFile(String fileName) {
        PointDouble3D[] pointVector = PointDouble3D.getPointDoubleVector(pointList);
        try (Formatter file = new Formatter(new File(fileName.concat(".txt")))) {
            file.format("%d\n", pointVector.length);
            for (PointDouble3D point : pointVector)
                file.format("%1.0f %1.0f\n", point.x, point.y);
        } catch (FileNotFoundException ex) {
            taConsole.append("\nO arquivo não pôde ser criado.");
        }
        savePointList();
        refreshSavedPointLists();
    }
    
    private boolean loadPointListFromFile(String fileName) {
        Point3D[] pointListVector;
        try (Scanner file = new Scanner(new File(fileName.concat(".txt")))) {
            int size = 0;
            if (file.hasNextLine())
                size = Integer.parseInt(file.nextLine());
            pointListVector = new Point3D[size];
            int i = 0;
            while(file.hasNextLine()) {
                String[] pontos = file.nextLine().split(" ");
                int x = Integer.parseInt(pontos[0]);
                int y = Integer.parseInt(pontos[1]);
                Point3D newPoint = new Point3D(x,y);
                pointListVector[i] = newPoint;
                i++;
            }
            file.close();
            PointList loadedPointList = new PointList();
            for (int j = pointListVector.length-1; j >= 0; j--)
                loadedPointList = new PointList(loadedPointList, pointListVector[j]);

            pointList = loadedPointList;
            savePointList();
            refreshSavedPointLists();
            pointVectorSurfacePoints = deslocatedPointVectorSurfacePoints = globalPointVector = globalDeslocatedPointVector = null;
            return true;
        } catch (FileNotFoundException ex) {
            taConsole.append("\nArquivo não foi encontrado.");
            return false;
        }
    }
    
    private void refreshSavedPointLists() {
        lsSavedPointLists.setModel(new javax.swing.AbstractListModel() {
            String[] strings = getPointListsString();
            @Override
            public int getSize() { return strings.length; }
            @Override
            public Object getElementAt(int i) { return strings[i]; }
        });
    }
    
    private String[] getPointListsString() {
        int index = 0;
        String[] stringList = new String[savedPointLists.size()];
        
        for (Object item : savedPointLists) {
            PointList pointListItem = (PointList) item;
            stringList[index] = String.format("Lista %d (%d pontos - Início:[%d,%d])",
                index, pointListItem.pointCount(),pointListItem.point.x, pointListItem.point.y);
            index++;
        }
        
        return stringList;
    }
    
    private int selectPointList() {
        int selected = lsSavedPointLists.getSelectedIndex();
        if(selected >= 0)
            pointList = (PointList) savedPointLists.get(selected);
        return selected;
    }
    
    private int deletePointList() {
        int selected = lsSavedPointLists.getSelectedIndex();
        if(selected >= 0) {
            if(pointList.equals(savedPointLists.get(selected))) {
                pointList = new PointList();
                clearScreen();
            }
            savedPointLists.remove(selected);
            refreshSavedPointLists();
        }
        return selected;
    }
    
    private PointDouble3D[] getInvertedPointVector(Point3D[] pointVector) {
        if (pointVector.length > 0) {
            PointDouble3D[] invertedPointVector = new PointDouble3D[pointVector.length];
            for (int i = 0; i < pointVector.length; i++)
                invertedPointVector[i] = new PointDouble3D(pointVector[pointVector.length-1-i]);
            return invertedPointVector;
        }
        return null;
    }
    
    private PointDouble3D[] getInvertedPointVector(PointDouble3D[] pointVector) {
        if (pointVector.length > 0) {
            PointDouble3D[] invertedPointVector = new PointDouble3D[pointVector.length];
            for (int i = 0; i < pointVector.length; i++)
                invertedPointVector[i] = pointVector[pointVector.length-1-i];
            return invertedPointVector;
        }
        return null;
    }
     
    @SuppressWarnings("ManualArrayToCollectionCopy")
    private Point3D[] checkForEmptyPoints(Point3D[] pointVector) {
        if(pointVector.length > 0) {
            int length = 0;
            while (length < pointVector.length) {
                if (pointVector[length] == null)
                    break;
                length++;
            }
            Point3D[] correctedPointVector = new Point3D[length];
            for (int i = 0; i < length; i++)
                correctedPointVector[i] = pointVector[i];
            return correctedPointVector;
        }
        return null;
    }
    
    @SuppressWarnings("ManualArrayToCollectionCopy")
    private PointDouble3D[] checkForEmptyPoints(PointDouble3D[] pointVector) {
        if(pointVector.length > 0) {
            int length = 0;
            while (length < pointVector.length) {
                if (pointVector[length] == null)
                    break;
                length++;
            }
            PointDouble3D[] correctedPointVector = new PointDouble3D[length];
            for (int i = 0; i < length; i++)
                correctedPointVector[i] = pointVector[i];
            return correctedPointVector;
        }
        return null;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="MÉTODOS DE GRÁFICOS">   
    private void clearScreen() {
        Graphics graphics = pnScreen.getGraphics();
        graphics.clearRect(0, 0, actualScreenLimitX, actualScreenLimitY);
        graphics.dispose();
    }
    
    private Color getRandomColor() {
        Random random = new Random();
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        return new Color(r, g, b);
    }
    
    private void paintPoint(Point3D point) {
        paintPoint(point, getRandomColor());
    }
    
    private void paintPoint(Point3D point, Color color) {
        if (color == null)
            paintPoint(point);
        else {
            Graphics graphics = pnScreen.getGraphics();
            graphics.setColor(color);
            graphics.fillOval(point.x,point.y,6,6);
            graphics.dispose();
        }
    }
    
    private void paintPoint(PointDouble3D point) {
        paintPoint(new Point3D(point));
    }
    
    private void paintPoint(PointDouble3D point, Color color) {
        paintPoint(new Point3D(point), color);
    }
    
    private void paintPointList(PointList pointList) {
        if(pointList.father != null)
            paintPointList(pointList.father);
        if(pointList.point != null)
             paintPoint(getPointOutInverted(pointList.point));
    }
    
    private void paintPointVectorWithDashes(PointDouble3D[] pointVector) {
        if(pointVector.length > 0) {
            for (int i = 0; i < pointVector.length; i++) {
                paintPoint(getPointOutInverted(pointVector[i]), Color.WHITE);
                if (i < pointVector.length-1)
                    drawDashedLine(getPointOutInverted(pointVector[i]),getPointOutInverted(pointVector[i+1]));
            }
        }      
    }
    
    private void paintProjectedPointVectorWithDashes(PointDouble3D[] pointVector, double fieldOfView) {
        if(pointVector.length > 0) {
            for (int i = 0; i < pointVector.length; i++) {
                paintPoint(getPointOutInverted(getProjectedPoint(new Point3D(pointVector[i]), fieldOfView)), Color.WHITE);
                if (i < pointVector.length-1)
                    drawDashedLine(getPointOutInverted(getProjectedPoint(new Point3D(pointVector[i]), fieldOfView)),getPointOutInverted(getProjectedPoint(new Point3D(pointVector[i+1]), fieldOfView)));
            }
        } 
    }
    
    private void paintConnectionBetweenPointVectorsWithDashes(Point3D[] pointVector, Point3D[] projectedPointVector, double fieldOfView) {
        drawDashedLine(getPointOutInverted(pointVector[0]),getPointOutInverted(getProjectedPoint(projectedPointVector[0], fieldOfView)));
        drawDashedLine(getPointOutInverted(pointVector[pointVector.length-1]),getPointOutInverted(getProjectedPoint(projectedPointVector[projectedPointVector.length-1], fieldOfView)));
    }
    
    private void paintConnectionBetweenPointVectorsWithDashes(PointDouble3D[] pointVector, PointDouble3D[] projectedPointVector, double fieldOfView) {
        drawDashedLine(getPointOutInverted(pointVector[0]),getPointOutInverted(getProjectedPoint(new Point3D(projectedPointVector[0]), fieldOfView)));
        drawDashedLine(getPointOutInverted(pointVector[pointVector.length-1]),getPointOutInverted(getProjectedPoint(new Point3D(projectedPointVector[projectedPointVector.length-1]), fieldOfView)));
    }
    
    private void connectPoints(PointList pointList) {   
        Point3D p1 = pointList.point;
        Point3D p2 = pointList.father.point;
        
        if (p1 != null)
            p1 = getPointOutInverted(p1);
        
        if (p2 != null)
            p2 = getPointOutInverted(p2);
        
        if (p1 != null && p2 != null) {
            Graphics graphics = pnScreen.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.drawLine(p1.x, p1.y, p2.x, p2.y);
            if (pointList.father != null)
                connectPoints(pointList.father);
            graphics.dispose();
        }
    }
    
    private void disableEnablePointingButton() {
        if (isPointing) {
            isPointing = false;
            btEnablePointing.setText("Ativar Clique para Criar Pontos");
            btEnablePointing.setSelected(false);
            taConsole.append("\nCriação de pontos DESATIVADA.");
        }
    }
    
    private void drawLine(Point3D p1, Point3D p2) {
        drawLine(p1, p2, Color.WHITE);
    }
    
    private void drawLine(Point3D p1, Point3D p2, Color color) {
        Graphics graphics = pnScreen.getGraphics();
        graphics.setColor(color);
        graphics.drawLine(p1.x, p1.y, p2.x, p2.y);
        graphics.dispose();
    }
    
    private void drawLine(PointDouble3D p1, PointDouble3D p2) {
        drawLine(new Point3D(p1), new Point3D(p2), Color.WHITE);
    }
    
    private void drawLine(PointDouble3D p1, PointDouble3D p2, Color color) {
        drawLine(new Point3D(p1), new Point3D(p2), color);
    }
    
    private void drawDashedLine(Point3D p1, Point3D p2) {
        Point3D[] pointsDashed = p1.getSubPoints(p2, 10);
        if(pointsDashed.length > 0) {
            for (int i = 1; i < pointsDashed.length-1; i+=2) {
                drawLine(pointsDashed[i],pointsDashed[i+1]);
            }
        }    
    }
    
    private void drawText(String text, int x, int y) {
        drawText(text, new Point3D(x,y), Color.WHITE);
    }
    
    private void drawText(String text, Point3D point) {
        drawText(text, point, Color.WHITE);
    }
    
    private void drawText(String text, int x, int y, Color color) {
        drawText(text, new Point3D(x,y), color);
    }
    
    private void drawText(String text, Point3D point, Color color) {
        Graphics graphics = pnScreen.getGraphics();
        graphics.setColor(color);
        graphics.drawString(text, point.x, point.y);
        graphics.dispose();
    }
    
    private void drawLightDirection() {
        Point3D p1 = new Point3D(screenLimitX,0);
        Point3D p2 = new Point3D(screenLimitX-40,40);
        Point3D p3 = new Point3D(screenLimitX-40,30);
        Point3D p4 = new Point3D(screenLimitX-30,40);
        Point3D pText = new Point3D(screenLimitX-150, 20);
        Color color = Color.YELLOW;
        String text = "Luz (45º com eixo X)";
        
        drawLine(p1, p2, color);
        drawLine(p2, p3, color);
        drawLine(p2, p4, color);
        drawText(text, pText, color);
    }
    
    private Color getBlue() {
        return new Color(42,42,180);
    }
    
    private Color getBlue(int i) {
        if (i >= 0 && i <= 255)
            return new Color(42,42,i);
        else
            return getBlue();
    }
    
    private Color getGreen() {
        return new Color(42,180,42);
    }
    
    private Color getGreen(int i) {
        if (i >= 0 && i <= 255)
            return new Color(42,i,42);
        else
            return getGreen();
    }
// </editor-fold>  
    
// <editor-fold defaultstate="collapsed" desc="MÉTODOS B-SPLINE"> 
    private void drawSplineCurve() {
        //Verifica se a lista está vazia
        if(pointList.pointCount() > 0) {         
            //Transforma a lista de pontos em um vetor e traça os pontos
            globalPointVector = PointDouble3D.getPointDoubleVector(pointList);            
            paintPointVectorWithDashes(getInvertedPointVector(globalPointVector));
            //Desenha a Curva B-Spline Quadrática
            int precisionPoints = 100;
            drawQuadraticSplineCurveFromVector(globalPointVector, precisionPoints);
        }
        //Se estiver vazia, retorna e imprime erro
        else
            taConsole.append("\n\nLista vazia.");
    }
    
    private void drawQuadraticSplineCurveFromVector(PointDouble3D[] vector, int precisionPoints) {
        int i = 0;
        while(i+2 < vector.length) {
            Double stepSize = 1.0 / precisionPoints;
            Point3D nowPoint = new Point3D(0,0);
            
            for (double t = 0; t <= 1; t += stepSize) {
                double coordinatesX, coordinatesY;
                coordinatesX = ((+1 -2*t +1*Math.pow(t,2)) * vector[i].x +
                                (+1 +2*t -2*Math.pow(t,2)) * vector[i+1].x +
                                (+0 +0*t +1*Math.pow(t,2)) * vector[i+2].x)/2;
                coordinatesY = ((+1 -2*t +1*Math.pow(t,2)) * vector[i].y +
                                (+1 +2*t -2*Math.pow(t,2)) * vector[i+1].y +
                                (+0 +0*t +1*Math.pow(t,2)) * vector[i+2].y)/2;

                Point3D nextPoint = getPointOutInverted(new Point3D(coordinatesX, coordinatesY));
                
                if(t!=0) 
                    drawLine(nowPoint, nextPoint);//Desenha linha do nowPoint atual até o ponto, e atualiza
                
                nowPoint = nextPoint;//Move nowPoint para o ponto
            }
            i++;
        }
    }
    
    private void drawCubicSplineCurveFromVector(PointDouble3D[] vector, int precisionPoints) {
        //TEM QUE SER MODIFICADO DE ACORDO COM O QUADRÁTICO
        int i = 0;
        while(i+3 < vector.length) {
            Double stepSize = 1.0 / precisionPoints;
            Point3D nowPoint = new Point3D(0,0);
            
            for (double t = 0; t <= 1; t += stepSize) {
                double coordX,coordY;
                coordX = ((-1*Math.pow(t,3) +3*Math.pow(t,2) -3*t +1) * vector[i].x +
                          (+3*Math.pow(t,3) -6*Math.pow(t,2) +0*t +4) * vector[i+1].x + 
                          (-3*Math.pow(t,3) +3*Math.pow(t,2) +3*t +1) * vector[i+2].x +
                          (+1*Math.pow(t,3) +0*Math.pow(t,2) +0*t +0) * vector[i+3].x)/6;
                coordY = ((-1*Math.pow(t,3) +3*Math.pow(t,2) -3*t +1) * vector[i].y +
                          (+3*Math.pow(t,3) -6*Math.pow(t,2) +0*t +4) * vector[i+1].y + 
                          (-3*Math.pow(t,3) +3*Math.pow(t,2) +3*t +1) * vector[i+2].y +
                          (+1*Math.pow(t,3) +0*Math.pow(t,2) +0*t +0) * vector[i+3].y)/6;

                Point3D nextPoint = getPointOutInverted(new Point3D(coordX, coordY));
                
                if(t!=0) 
                    drawLine(nowPoint, nextPoint);//Desenha linha do nowPoint atual até o ponto, e atualiza
                
                nowPoint = nextPoint;//Move nowPoint para o ponto
            }
            i++;
        }
    }
    
    private void drawQuadraticSplineCurveFromVectorWithProjection(PointDouble3D[] vector, int precisionPoints, double fieldOfView) {
        int i = 0;
        while(i+2 < vector.length) {
            Double stepSize = 1.0 / precisionPoints;
            Point3D nowPoint = new Point3D(0,0,0);
            
            for (double t = 0; t <= 1; t += stepSize) {
                double coordinateX, coordinateY, coordinateZ;
                coordinateX = ((+1 -2*t +1*Math.pow(t,2)) * vector[i].x +
                                (+1 +2*t -2*Math.pow(t,2)) * vector[i+1].x +
                                (+0 +0*t +1*Math.pow(t,2)) * vector[i+2].x)/2;
                coordinateY = ((+1 -2*t +1*Math.pow(t,2)) * vector[i].y +
                                (+1 +2*t -2*Math.pow(t,2)) * vector[i+1].y +
                                (+0 +0*t +1*Math.pow(t,2)) * vector[i+2].y)/2;
                coordinateZ = vector[i].z;
                
                Point3D nextPoint = new Point3D(coordinateX, coordinateY, coordinateZ);
                nextPoint = getPointOutInverted(getProjectedPoint(nextPoint, fieldOfView));
                
                if(t!=0) 
                    drawLine(nowPoint, nextPoint);//Desenha linha do nowPoint atual até o ponto, e atualiza
                
                nowPoint = nextPoint;//Move nowPoint para o ponto
            }
            i++;
        }
    }
// </editor-fold> 

// <editor-fold defaultstate="collapsed" desc="MÉTODOS DE PROJEÇÃO">
    private Point3D getProjectedPoint(Point3D point, double FOV) {       
        if (point != null) {
            double scale = point.z / FOV;
            int newX = (int) Math.round(((point.x) / (actualScreenLimitX * scale)) + (actualScreenLimitX/4));
            int newY = (int) Math.round(((point.y) / (actualScreenLimitY * scale)) + (actualScreenLimitY/4));                
            return new Point3D(newX,newY,point.z);
        }
        return null;
    }
    
    private PointDouble3D getProjectedPointDouble(PointDouble3D point, double FOV) {       
        if (point != null) {
            double scale = point.z / FOV;
            double newX = ((point.x) / (actualScreenLimitX * scale)) + (actualScreenLimitX/4);
            double newY = ((point.y) / (actualScreenLimitY * scale)) + (actualScreenLimitY/4);                
            return new PointDouble3D(newX,newY,point.z);
        }
        return null;
    }
    
    private double getBiggestControlPointsDistance(Point3D[] pointVector) {
        double biggestCPDistance = 0;
        biggestDistancePoint1 = biggestDistancePoint2 = null;
        if (pointVector.length > 1) {
            for (Point3D point1 : pointVector) {
                for (Point3D point2 : pointVector) {
                    double distance = Point3D.getDistance(point1, point2);
                    if (distance > biggestCPDistance) {
                        biggestCPDistance = distance;
                        biggestDistancePoint1 = new PointDouble3D(point1);
                        biggestDistancePoint2 = new PointDouble3D(point2);
                    }
                }
            }
        }        
        return biggestCPDistance;
    }
    
    private double getBiggestControlPointsDistance(PointDouble3D[] pointVector) {
        double biggestCPDistance = 0.0;
        biggestDistancePoint1 = biggestDistancePoint2 = null;
        if (pointVector.length > 1) {
            for (PointDouble3D point1 : pointVector) {
                for (PointDouble3D point2 : pointVector) {
                    double distance = PointDouble3D.getDistance(point1, point2);
                    if (distance > biggestCPDistance) {
                        biggestCPDistance = distance;
                        biggestDistancePoint1 = point1;
                        biggestDistancePoint2 = point2;
                    }
                }
            }
        }        
        return biggestCPDistance;
    }
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="MÉTODOS DE SUPERFÍCIE">
    private void drawSurface() {
        if (pointList.pointCount() > 0 && globalPointVector.length > 0 &&
            pointList.pointCount() == globalPointVector.length) {
            
            //Transforma a lista de pontos em um vetor e traça os pontos
            globalPointVector = PointDouble3D.getPointDoubleVector(pointList);            
            paintPointVectorWithDashes(getInvertedPointVector(globalPointVector));
            //Desenha a Curva B-Spline Quadrática
            int precisionPoints = 100;
            drawQuadraticSplineCurveFromVector(globalPointVector, precisionPoints);
            
            int delocationRatio = 10;
            int surfacePrecision = 500;
            double distance = getBiggestControlPointsDistance(globalPointVector);
            double fieldOfView = distance * 40;
            taConsole.append(String.format("\n\nDesenhando superfície apartir da curva por DESLOCAMENTO de %1.2f no eixo Z.", distance/delocationRatio));
            taConsole.append(String.format("\nConvex Hull: %1.2f", distance));
            taConsole.append(String.format("\nDistância do Ponto de Fuga no eixo Z: %1.2f", fieldOfView));
            
            //Obtém os pontos da curva curva projetada
            globalDeslocatedPointVector = PointDouble3D.getDeslocatedPointDoubleVector(pointList, distance, delocationRatio);
            paintProjectedPointVectorWithDashes(getInvertedPointVector(globalDeslocatedPointVector), fieldOfView);
            paintConnectionBetweenPointVectorsWithDashes(globalPointVector, globalDeslocatedPointVector, fieldOfView);
            //Desenha a curva projetada
            drawQuadraticSplineCurveFromVectorWithProjection(globalDeslocatedPointVector, precisionPoints, fieldOfView);
            //Desenha as arestas entre as duas curvas
            defineSurfacePoints(globalPointVector, globalDeslocatedPointVector, precisionPoints, surfacePrecision, fieldOfView);
        }
        else
            taConsole.append("\nA superfície não pôde ser desenhada!\n" +
                                "Desenhe primeiro a curva B-Spline.");
    }
    
    private void defineSurfacePoints(PointDouble3D[] pointVector, PointDouble3D[] deslocatedPointVector, int precisionPoints, int surfacePrecision, double fieldOfView) {
        if (pointVector.length > 0 && deslocatedPointVector.length > 0 && pointVector.length == deslocatedPointVector.length) {
            pointVectorSurfacePoints = getSurfacePoints(pointVector, precisionPoints, surfacePrecision);
            deslocatedPointVectorSurfacePoints = getProjectedSurfacePoints(deslocatedPointVector, precisionPoints, surfacePrecision, fieldOfView);
            drawRenderedSurface();
        }
    }
    
    private void drawRenderedSurface() {
        for (int i = 0; i < pointVectorSurfacePoints.length; i++) {
            if ((i+2) < pointVectorSurfacePoints.length) {
                PointDouble3D p1 = pointVectorSurfacePoints[i];
                PointDouble3D p2 = pointVectorSurfacePoints[i+1];
                PointDouble3D p3 = pointVectorSurfacePoints[i+2];
                boolean xFactorClock = p2.x >= p1.x + 0.25;
                boolean yFactorClock = p2.y >= p1.y;
                boolean xFactorAntiClock = p2.x >= p1.x - 0.25;
                boolean yFactorAntiClock = p2.y >= p1.y;
                
                //HORÁRIO
                if(getClock(p1,p2,p3).equals("horario")) {
                    //(-1,-1) -> p2.x >= p1.x && p2.y >= p1.y
                    if (xFactorClock && yFactorClock)
                        p1.setColor(getBlue());
                    //(+1,-1) -> p2.x >= p1.x && p2.y < p1.y
                    if (xFactorClock && !yFactorClock)
                        p1.setColor(getBlue());//Color.ORANGE;
                    //(-1,+1) -> p2.x < p1.x && p2.y >= p1.y
                    if (!xFactorClock && yFactorClock)
                        p1.setColor(getGreen());//Color.RED;
                    //(+1,+1) -> p2.x < p1.x && p2.y < p1.y
                    if (!xFactorClock && !yFactorClock)
                        p1.setColor(getGreen());//Color.YELLOW;
                }
                //ANTI-HORÁRIO
                else {
                    //(+1,+1) -> p2.x >= p1.x && p2.y >= p1.y
                    if (xFactorAntiClock && yFactorAntiClock)
                        p1.setColor(getBlue());
                    //(-1,+1) -> p2.x >= p1.x && p2.y < p1.y
                    if (xFactorAntiClock && !yFactorAntiClock)
                        p1.setColor(getBlue());//Color.PINK;
                    //(+1,-1) -> p2.x < p1.x && p2.y >= p1.y
                    if (!xFactorAntiClock && yFactorAntiClock)
                        p1.setColor(getGreen());//Color.MAGENTA;
                    //(-1,-1) -> p2.x < p1.x && p2.y < p1.y
                    if (!xFactorAntiClock && !yFactorAntiClock)
                        p1.setColor(getGreen());//Color.CYAN;
                }
            }
        }
        this.drawLayeredSurface(pointVectorSurfacePoints);
    }
    
    @SuppressWarnings("UnusedAssignment")
    private void drawLayeredSurface(PointDouble3D[] pointVector) {
        PointDouble3D[] initialPointVector = pointVector.clone();        
        PointDouble3D[] layeredVector = new PointDouble3D[pointVector.length];
        PointDouble3D[] finalLayeredVector = new PointDouble3D[pointVector.length];
        int count = 0;
        for (double i = screenLimitY; i >= 0; i-=0.001) {
            layeredVector = getMinYPoints(initialPointVector, i);
            if (layeredVector.length > 0) {
                for (int j = 0; j < layeredVector.length; j++) {
                    PointDouble3D d = deslocatedPointVectorSurfacePoints[layeredVector[j].index];
                    drawLine(layeredVector[j], d, layeredVector[j].color); 
                }
                getLayeredVector(finalLayeredVector, layeredVector, count);
                count += layeredVector.length;
            }
        }
    }
    
    @SuppressWarnings("ManualArrayToCollectionCopy")
    private void getLayeredVector(PointDouble3D[] finalVector, PointDouble3D[] vector, int count) {
        for (int i = 0; i < vector.length; i++)
            finalVector[count+i] = vector[i];
    }
    
    private PointDouble3D[] getMinYPoints(PointDouble3D[] pointVector, double min) {
        PointDouble3D[] layeredVector = new PointDouble3D[pointVector.length];
        int count = 0;
        for (int i = 0; i < pointVector.length; i++) {
            if (pointVector[i].y >= min) {
                if (!pointVector[i].painted) {
                    pointVector[i] = pointVector[i].paint(i);
                    layeredVector[count] = pointVector[i];
                    count++;
                }
            }
        }
        return checkForEmptyPoints(layeredVector);
    }
    
    private PointDouble3D getGeometricalVectorFromPointDouble(PointDouble3D p1, PointDouble3D p2) {
        if (p1 != null && p2 != null) {
            double x = p2.x - p1.x;
            double y = p2.y - p1.y;
            double z = p2.z - p1.z;
            return new PointDouble3D(x,y,z);
        }
        return null;
    }
    
    private String getClock(PointDouble3D p1, PointDouble3D p2, PointDouble3D p3) {
        PointDouble3D AB = getGeometricalVectorFromPointDouble(p1,p2);
        PointDouble3D AC = getGeometricalVectorFromPointDouble(p1,p3);
        if (AB != null && AC != null)
            return (AB.x * AC.y) - (AB.y * AC.x) >= 0 ? "horario" : "anti-horario";
        return "invalido";
    }
    
    private PointDouble3D[] getSurfacePoints(PointDouble3D[] vector, int precisionPoints, int surfacePrecision) {        
        int forLoops = precisionPoints;
        int whileLoops = vector.length - 2;
        int totalLoops = forLoops * whileLoops;
        int loopCount = 0;
        int vectorCount = 0;
        double vectorStep = totalLoops/surfacePrecision;
        double stepSize = 1.0/precisionPoints;
        int i = 0;
        PointDouble3D nowPoint = new PointDouble3D(0,0);
        PointDouble3D[] surfacePointsVector;
        surfacePointsVector = new PointDouble3D[totalLoops + 1];
        while(i+2 < vector.length) { 
            if (vectorCount < surfacePointsVector.length) {
                for (double t = 0; t <= 1; t += stepSize) {
                    if (vectorCount >= surfacePointsVector.length)
                        break;
                    double coordinatesX, coordinatesY;
                    coordinatesX = ((+1 -2*t +1*Math.pow(t,2)) * vector[i].x +
                                    (+1 +2*t -2*Math.pow(t,2)) * vector[i+1].x +
                                    (+0 +0*t +1*Math.pow(t,2)) * vector[i+2].x)/2;
                    coordinatesY = ((+1 -2*t +1*Math.pow(t,2)) * vector[i].y +
                                    (+1 +2*t -2*Math.pow(t,2)) * vector[i+1].y +
                                    (+0 +0*t +1*Math.pow(t,2)) * vector[i+2].y)/2;

                    nowPoint = getPointDoubleOutInverted(new PointDouble3D(coordinatesX, coordinatesY));

                    if (loopCount >= vectorStep * vectorCount) {
                        surfacePointsVector[vectorCount] = nowPoint;
                        vectorCount++;
                    }       
                    loopCount++;
                }
                i++;
            }
        }
        surfacePointsVector[surfacePointsVector.length-1] = nowPoint;
        return checkForEmptyPoints(surfacePointsVector);
    }
    
    private PointDouble3D[] getProjectedSurfacePoints(PointDouble3D[] vector, int precisionPoints, int surfacePrecision, double fieldOfView) {
        int forLoops = precisionPoints;
        int whileLoops = vector.length - 2;
        int totalLoops = forLoops * whileLoops;
        int loopCount = 0;
        int vectorCount = 0;
        double vectorStep = totalLoops/surfacePrecision;
        double stepSize = 1.0 / precisionPoints;
        int i = 0;
        PointDouble3D nowPoint = new PointDouble3D(0,0,0);
        PointDouble3D[] projectedSurfacePointsVector;
        projectedSurfacePointsVector = new PointDouble3D[totalLoops + 1];
        while(i+2 < vector.length) {
            if (vectorCount < projectedSurfacePointsVector.length) {
                for (double t = 0; t <= 1; t += stepSize) {
                    if (vectorCount >= projectedSurfacePointsVector.length)
                        break;
                    double coordinateX, coordinateY, coordinateZ;
                    coordinateX = ((+1 -2*t +1*Math.pow(t,2)) * vector[i].x +
                                    (+1 +2*t -2*Math.pow(t,2)) * vector[i+1].x +
                                    (+0 +0*t +1*Math.pow(t,2)) * vector[i+2].x)/2;
                    coordinateY = ((+1 -2*t +1*Math.pow(t,2)) * vector[i].y +
                                    (+1 +2*t -2*Math.pow(t,2)) * vector[i+1].y +
                                    (+0 +0*t +1*Math.pow(t,2)) * vector[i+2].y)/2;
                    coordinateZ = vector[i].z;

                    nowPoint = new PointDouble3D(coordinateX, coordinateY, coordinateZ);
                    nowPoint = getPointDoubleOutInverted(getProjectedPointDouble(nowPoint, fieldOfView));
                    if (loopCount >= vectorStep * vectorCount) {
                        projectedSurfacePointsVector[vectorCount] = nowPoint;
                        vectorCount++;
                    }       
                    loopCount++;
                }
                i++;
            }
        }
        projectedSurfacePointsVector[projectedSurfacePointsVector.length-1] = nowPoint;
        return checkForEmptyPoints(projectedSurfacePointsVector);
    }
// </editor-fold>    
    
// <editor-fold defaultstate="collapsed" desc="MÉTODOS DE ESTRUTURA DE DADOS"> 
    private void generateDataStructure() {
        if (pointVectorSurfacePoints != null && deslocatedPointVectorSurfacePoints != null &&
            pointVectorSurfacePoints.length > 0 && deslocatedPointVectorSurfacePoints.length > 0) {
            
            PointDouble3D[] dataStructurePoints = PointDouble3D.getPointDoubleVector(pointList);
            int precisionPoints = 100;
            drawQuadraticSplineCurveFromVector(globalPointVector, precisionPoints);
            int delocationRatio = 10;
            double distance = getBiggestControlPointsDistance(dataStructurePoints);
            double fieldOfView = distance * 40;
            PointDouble3D[] deslocatedDataStructurePoints = PointDouble3D.getDeslocatedPointDoubleVector(pointList, distance, delocationRatio);
            drawQuadraticSplineCurveFromVectorWithProjection(globalDeslocatedPointVector, precisionPoints, fieldOfView);
            
            int surfacePrecision = 20;
            dataStructurePoints = getSurfacePoints(dataStructurePoints, precisionPoints, surfacePrecision);
            deslocatedDataStructurePoints = getProjectedSurfacePoints(deslocatedDataStructurePoints, precisionPoints, surfacePrecision, fieldOfView);
            drawDataStructure(dataStructurePoints, deslocatedDataStructurePoints);
            estruturaDeDadosDaSuperficie = DataStructure.generate(dataStructurePoints, deslocatedDataStructurePoints);
            taConsole.append(estruturaDeDadosDaSuperficie.toString());
        }
        else
            taConsole.append(String.format("\nA estrutura de dados não pôde ser gerada!\nDesenhe primeiro a superfície."));
    }
    
    private void drawDataStructure(PointDouble3D[] dataStructurePoints, PointDouble3D[] deslocatedDataStructurePoints) {
        for (int i = 0; i < dataStructurePoints.length; i++) {
            drawLine(dataStructurePoints[i], deslocatedDataStructurePoints[i]);
            if (i < dataStructurePoints.length-1)
                drawLine(dataStructurePoints[i], deslocatedDataStructurePoints[i+1]);
        }
    }
// </editor-fold> 
    
// <editor-fold defaultstate="collapsed" desc="MÉTODOS DE ILUMINAÇÃO">     
    private void drawIluminationEffect() {
        paintPointVectorWithDashes(getInvertedPointVector(globalPointVector));
        double distance = getBiggestControlPointsDistance(globalPointVector);
        double fieldOfView = distance * 40;
        paintProjectedPointVectorWithDashes(getInvertedPointVector(globalDeslocatedPointVector), fieldOfView);
        paintConnectionBetweenPointVectorsWithDashes(globalPointVector, globalDeslocatedPointVector, fieldOfView);
        
        for (int i = 0; i < pointVectorSurfacePoints.length; i++) {
            if ((i+2) < pointVectorSurfacePoints.length) {
                PointDouble3D p1 = pointVectorSurfacePoints[i];
                PointDouble3D p2 = pointVectorSurfacePoints[i+1];
                PointDouble3D p3 = pointVectorSurfacePoints[i+2];
                boolean xFactorClock = p2.x >= p1.x + 0.25;
                boolean yFactorClock = p2.y >= p1.y;
                boolean xFactorAntiClock = p2.x >= p1.x - 0.25;
                boolean yFactorAntiClock = p2.y >= p1.y;
                
                //HORÁRIO
                if(getClock(p1,p2,p3).equals("horario")) {
                    //(-1,-1) -> p2.x >= p1.x && p2.y >= p1.y
                    if (xFactorClock && yFactorClock)
                        p1.setColor(getBlue(240));//Color.GREEN;getBlue()
                    //(+1,-1) -> p2.x >= p1.x && p2.y < p1.y
                    if (xFactorClock && !yFactorClock)
                        p1.setColor(getBlue(100));//Color.ORANGE;getBlue()
                    //(-1,+1) -> p2.x < p1.x && p2.y >= p1.y
                    if (!xFactorClock && yFactorClock)
                        p1.setColor(getGreen(100));//Color.RED;getGreen()
                    //(+1,+1) -> p2.x < p1.x && p2.y < p1.y
                    if (!xFactorClock && !yFactorClock)
                        p1.setColor(getGreen(200));//Color.YELLOW;getGreen()
                }
                //ANTI-HORÁRIO
                else {
                    //(+1,+1) -> p2.x >= p1.x && p2.y >= p1.y
                    if (xFactorAntiClock && yFactorAntiClock)
                        p1.setColor(getBlue(240));//Color.BLUE;getBlue()
                    //(-1,+1) -> p2.x >= p1.x && p2.y < p1.y
                    if (xFactorAntiClock && !yFactorAntiClock)
                        p1.setColor(getBlue(100));//Color.PINK;getBlue()
                    //(+1,-1) -> p2.x < p1.x && p2.y >= p1.y
                    if (!xFactorAntiClock && yFactorAntiClock)
                        p1.setColor(getGreen(100));//Color.MAGENTA;getGreen()
                    //(-1,-1) -> p2.x < p1.x && p2.y < p1.y
                    if (!xFactorAntiClock && !yFactorAntiClock)
                        p1.setColor(getGreen(200));//Color.CYAN;getGreen()
                }
                
                /*//Controla a luminosidade
                double distanceX = p2.x-p1.x;
                double distanceY = p2.y-p1.y;
                double factor = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));*/
            }
        }      
        this.drawLayeredSurface(pointVectorSurfacePoints);
    }
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="MÉTODOS MOUSE CLICKED"> 
    private void pnScreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnScreenMouseClicked
        if (isPointing) {
            Point3D pontoAdicionado = getPointInInverted(Point3D.getPoint3DFrom2D(evt.getPoint()));
            paintPoint(Point3D.getPoint3DFrom2D(evt.getPoint()));
            pointList = new PointList(pointList,pontoAdicionado);
            taConsole.append(String.format("\nPonto adicionado: [%d,%d]", pontoAdicionado.x, pontoAdicionado.y));
        }
    }//GEN-LAST:event_pnScreenMouseClicked

    private void btClearConsoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClearConsoleMouseClicked
        taConsole.setText("");
    }//GEN-LAST:event_btClearConsoleMouseClicked

    private void btSelectPointListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSelectPointListMouseClicked
        disableEnablePointingButton();
        if (savedPointLists.size() <= 0)
        taConsole.append("\n\nNão há listas salvas.");
        else {
            taConsole.append("\n\nSelecionando...");
            int selected = selectPointList();
            if (selected >= 0)
            taConsole.append(String.format("\nLista %d selecionada com sucesso!",selected));
            else
            taConsole.append("\nNenhuma lista foi selecionada.");
        }
    }//GEN-LAST:event_btSelectPointListMouseClicked

    private void btClearAllSavedPointListsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClearAllSavedPointListsMouseClicked
        disableEnablePointingButton();
        if (savedPointLists.size() <= 0)
        taConsole.append("\n\nNão há listas salvas.");
        else {
            int option = JOptionPane.showConfirmDialog(
                null,"Tem certeza que quer limpar todas as listas?",
                "Confirmar",JOptionPane.YES_NO_OPTION);
            if(option == 0){
                clearSavedPointLists();
                pointList = new PointList();
                clearScreen();
                taConsole.append("\n\nLimpando listas salvas...\nTodas as listas foram apagadas!");
            }
            else
            taConsole.append("\n\nLimpeza de listas cancelada.");
        }
    }//GEN-LAST:event_btClearAllSavedPointListsMouseClicked

    private void btDeletePointListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeletePointListMouseClicked
        disableEnablePointingButton();
        if (savedPointLists.size() <= 0)
        taConsole.append("\n\nNão há listas salvas.");
        else {
            taConsole.append("\n\nDeletando...");
            int option = JOptionPane.showConfirmDialog(
                null,"Tem certeza que deseja apagar essa lista?",
                "Confirmar",JOptionPane.YES_NO_OPTION);
            if(option == 0){
                int deleted = deletePointList();
                if (deleted >= 0)
                taConsole.append(String.format("\nLista %d apagada com sucesso!",deleted));
                else
                taConsole.append("\nNenhuma lista foi selecionada.");
            }
            else
            taConsole.append("\n\nRemoção cancelada.");
        }
    }//GEN-LAST:event_btDeletePointListMouseClicked

    private void btDrawBSplineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDrawBSplineMouseClicked
        disableEnablePointingButton();
        if (pointList.pointCount() <= 0)
        taConsole.append("\n\nNão foi possível desenhar as curva B-Spline Quadrática.\nA lista de pontos está vazia.");
        else {
            drawSplineCurve();
            taConsole.append("\n\nDesenhando curva...\nA curva B-Spline Quadrática foi desenhada com sucesso!");
        }
    }//GEN-LAST:event_btDrawBSplineMouseClicked

    private void btSavePointListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSavePointListMouseClicked
        disableEnablePointingButton();
        if (pointList.pointCount() <= 0)
            taConsole.append("\n\nNão foi possível salvar a lista de pontos.\nEla está vazia.");
        else {
            savePointList();
            taConsole.append("\n\nSalvado lista de pontos...\nLista de pontos salva com sucesso!");
        }
    }//GEN-LAST:event_btSavePointListMouseClicked

    private void btClearPointArrayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClearPointArrayMouseClicked
        disableEnablePointingButton();
        if(pointList.pointCount() <= 0)
        taConsole.append("\n\nA lista de pontos já está vazia.");
        else {
            int option = JOptionPane.showConfirmDialog(
                null,"Tem certeza que quer limpa a lista de pontos atual?",
                "Confirmar",JOptionPane.YES_NO_OPTION);
            if(option == 0){
                pointList = new PointList();
                pointVectorSurfacePoints = deslocatedPointVectorSurfacePoints = globalPointVector = globalDeslocatedPointVector = null;
                clearScreen();
                taConsole.append("\n\nLimpando lista de pontos...\nA lista de pontos foi limpa com sucesso!");
            }
            else
            taConsole.append("\n\nLimpeza da lista cancelada.");
        }
    }//GEN-LAST:event_btClearPointArrayMouseClicked

    private void btEditPointsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEditPointsMouseClicked
        disableEnablePointingButton();
        if (pointList.pointCount() <= 0)
        taConsole.append("\n\nNão foi possível editar os pontos.\nA lista de pontos está vazia.");
        else {
            taConsole.append("\n\nEditando lista de pontos...");
            Point3D points[] = editPoint();
            if(points == null) {
                taConsole.append("\nAção cancelada ou valores inválidos.");
            }
            else {
                taConsole.append(String.format("\nPonto modificado: [%d,%d] -> [%d,%d]",
                    points[0].x,points[0].y,points[1].x,points[1].y));
            taConsole.append("\nLista de pontos editada com sucesso!");
            clearScreen();
        }
        }
    }//GEN-LAST:event_btEditPointsMouseClicked

    private void btPrintPointsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPrintPointsMouseClicked
        disableEnablePointingButton();
        if (pointList.pointCount() <= 0)
        taConsole.append("\n\nA lista de pontos está vazia.");
        else {
            taConsole.append("\n\nLista de pontos clicados:\n" + pointList.toString());
        }
        taConsole.append("\nContagem de pontos: " + pointList.pointCount());
    }//GEN-LAST:event_btPrintPointsMouseClicked

    private void btConnectPointsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConnectPointsMouseClicked
        disableEnablePointingButton();
        if (pointList.pointCount() <= 0)
        taConsole.append("\n\nNão foi possível habilitar o Control Graph.\nA lista de pontos está vazia.");
        else {
            connectPoints(pointList);
            taConsole.append("\n\nConectando pontos...\nControl Graph ativado com sucesso!");
        }
    }//GEN-LAST:event_btConnectPointsMouseClicked

    private void btPaintPointsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPaintPointsMouseClicked
        disableEnablePointingButton();
        if (pointList.pointCount() <= 0)
        taConsole.append("\n\nNão foi possível desenhar os pontos.\nA lista de pontos está vazia.");
        else {
            paintPointList(pointList);
            taConsole.append("\n\nDesenhando pontos...\nA lista de pontos foi desenhada com sucesso!");
        }
    }//GEN-LAST:event_btPaintPointsMouseClicked

    private void btEnablePointingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEnablePointingMouseClicked
        if (btEnablePointing.getSelectedObjects() != null) {
            taConsole.append("\n\nCriação de pontos ATIVADA.\nClique agora na tela para criar pontos!");
            if(pointList.pointCount() > 0) {
                taConsole.append("\nContinuando a lista:\n" + pointList.toString());
                paintPointList(pointList);
            }
            isPointing = true;
            btEnablePointing.setText("Desativar Clique para Criar Pontos");

        }
        else {
            isPointing = false;
            btEnablePointing.setText("Ativar Clique para Criar Pontos");
            taConsole.append("\nCriação de pontos DESATIVADA.");
        }
    }//GEN-LAST:event_btEnablePointingMouseClicked

    private void btScreenLimitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btScreenLimitMouseClicked
        disableEnablePointingButton();
        if (tfScreenLimitX.getText().isEmpty() || tfScreenLimitY.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Por favor, preencha os limites corretamente. Somente números positivos serão aceitos.");
        else {
            int newScreenLimitX = Math.round(Float.parseFloat(tfScreenLimitX.getText()));
            int newScreenLimitY = Math.round(Float.parseFloat(tfScreenLimitY.getText()));
            proportionX = newScreenLimitX/(actualScreenLimitX * 1.0f);
            proportionY = newScreenLimitY/(actualScreenLimitY * 1.0f);
            String print = "\n\nMUDANÇA DE ÁREA DO PLANO";
            print += String.format("\nTamanho da área anterior (Window): [%d,%d]",screenLimitX,screenLimitY);
            print += String.format("\nTamanho da área novo (Window): [%d,%d]",newScreenLimitX,newScreenLimitY);
            print += String.format("\nProporção ao tamanho inicial (ViewPort) (600x600): (%.2f x %.2f)",proportionX,proportionY);
            taConsole.append(print);
            screenLimitX = newScreenLimitX;
            screenLimitY = newScreenLimitY;
            lbScreenMaxX.setText(String.valueOf(screenLimitX));
            lbScreenMaxY.setText(String.valueOf(screenLimitY));
            clearScreen();
        }
    }//GEN-LAST:event_btScreenLimitMouseClicked

    private void btClearScreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClearScreenMouseClicked
        disableEnablePointingButton();
        clearScreen();
        taConsole.append("\n\nLimpando a tela...\nA tela foi limpa com sucesso!");
    }//GEN-LAST:event_btClearScreenMouseClicked

    private void btDrawBiggestDistanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDrawBiggestDistanceMouseClicked
        disableEnablePointingButton();
        PointDouble3D[] pointVector = PointDouble3D.getPointDoubleVector(pointList);            
        double distance = getBiggestControlPointsDistance(pointVector); 
        taConsole.append("\n\nDesenhando a maior distância entre dois pontos de controle...");
        if (distance > 0.0) {
            drawLine(getPointOutInverted(biggestDistancePoint1), getPointOutInverted(biggestDistancePoint2), Color.RED);
            taConsole.append(String.format("\nDistância: %1.2f\nA reta de maior distância foi desenhada com sucesso!",distance));
        }
        else
            taConsole.append("\nNão foi possível determinar a maior distância.");
    }//GEN-LAST:event_btDrawBiggestDistanceMouseClicked

    @SuppressWarnings("null")
    private void btSaveFileListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSaveFileListMouseClicked
        disableEnablePointingButton();
        if (pointList.pointCount() <= 0)
            taConsole.append("\n\nNão foi possível salvar a lista de pontos.\nEla está vazia.");
        else {
            String fileName = "";
            while(fileName.isEmpty() || fileName == null) {
                fileName = (String) JOptionPane.showInputDialog(null,
                                "Digite o nome do arquivo.",
                                "Nome do arquivo", JOptionPane.PLAIN_MESSAGE, null, null, null);
            }
            savePointListToFile(fileName);
            taConsole.append("\n\nSalvado lista de pontos em arquivo...\nLista de pontos salva com sucesso!");
        }
    }//GEN-LAST:event_btSaveFileListMouseClicked

    @SuppressWarnings("null")
    private void btLoadFileListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLoadFileListMouseClicked
        disableEnablePointingButton();
        String fileName = "";
        while(fileName == null || fileName.isEmpty()) {
            fileName = (String) JOptionPane.showInputDialog(null,
                            "Digite o nome do arquivo sem '.txt'.\n"
                            + "Exemplo: lista1.txt\n"
                            + "Digite: lista1",
                            "Nome do arquivo", JOptionPane.PLAIN_MESSAGE, null, null, null);
        }
        taConsole.append("\n\nCarregando lista de pontos de arquivo...");
        if (loadPointListFromFile(fileName))
            taConsole.append("\nLista de pontos carregada com sucesso!");
        else
            taConsole.append("\nHouve um erro no carregamento.");
        
    }//GEN-LAST:event_btLoadFileListMouseClicked

    private void btLightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLightMouseClicked
        disableEnablePointingButton();        
        taConsole.append(String.format("\n\nAplicando iluminação de acordo com o modelo Lambertiano..."));
        if (pointVectorSurfacePoints == null || deslocatedPointVectorSurfacePoints == null || pointVectorSurfacePoints.length == 0 || deslocatedPointVectorSurfacePoints.length == 0)
            taConsole.append(String.format("\nNão foi possível aplicar a iluminação!\nDesenhe primeiro a superfície."));
        else {
            clearScreen();
            drawIluminationEffect();
            drawLightDirection();
        }
    }//GEN-LAST:event_btLightMouseClicked

    private void btTest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTest1MouseClicked
        disableEnablePointingButton();
        loadPointListFromFile("teste1");
        drawSplineCurve();
    }//GEN-LAST:event_btTest1MouseClicked

    private void btTest2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTest2MouseClicked
        disableEnablePointingButton();
        loadPointListFromFile("teste2");
        drawSplineCurve();
    }//GEN-LAST:event_btTest2MouseClicked

    private void btTest3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTest3MouseClicked
        disableEnablePointingButton();
        loadPointListFromFile("teste3");
        drawSplineCurve();
    }//GEN-LAST:event_btTest3MouseClicked

    private void btTest4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTest4MouseClicked
        disableEnablePointingButton();
        loadPointListFromFile("teste4");
        drawSplineCurve();
    }//GEN-LAST:event_btTest4MouseClicked

    private void btClearScreen2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClearScreen2MouseClicked
        disableEnablePointingButton();
        clearScreen();
        taConsole.append("\n\nLimpando a tela...\nA tela foi limpa com sucesso!");
    }//GEN-LAST:event_btClearScreen2MouseClicked

    private void btDataStructureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDataStructureMouseClicked
        disableEnablePointingButton();
        taConsole.append(String.format("\n\nGerando estrutura de dados a partir da superfície..."));
        //Gera a estrutura de dados da superfície
        generateDataStructure();
    }//GEN-LAST:event_btDataStructureMouseClicked

    private void btDataStructure2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDataStructure2MouseClicked
        disableEnablePointingButton();
        taConsole.append(String.format("\n\nGerando estrutura de dados a partir da superfície..."));
        //Gera a estrutura de dados da superfície
        generateDataStructure();
    }//GEN-LAST:event_btDataStructure2MouseClicked

    private void btSurfaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSurfaceMouseClicked
        disableEnablePointingButton();
        taConsole.append("\n\nDesenhando a superfície...");
        drawSurface();
    }//GEN-LAST:event_btSurfaceMouseClicked

    private void btSurface2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSurface2MouseClicked
        disableEnablePointingButton();
        taConsole.append("\n\nDesenhando a superfície...");
        drawSurface();
    }//GEN-LAST:event_btSurface2MouseClicked

    private void btLight2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLight2MouseClicked
        disableEnablePointingButton();        
        taConsole.append(String.format("\n\nAplicando iluminação de acordo com o modelo Lambertiano..."));
        if (pointVectorSurfacePoints == null || deslocatedPointVectorSurfacePoints == null || pointVectorSurfacePoints.length == 0 || deslocatedPointVectorSurfacePoints.length == 0)
            taConsole.append(String.format("\nNão foi possível aplicar a iluminação!\nDesenhe primeiro a superfície."));
        else {
            clearScreen();
            drawIluminationEffect();
            drawLightDirection();
        }
    }//GEN-LAST:event_btLight2MouseClicked

    @SuppressWarnings("static-access")
    private void btDrawEdgesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDrawEdgesMouseClicked
        disableEnablePointingButton();
        if (pointVectorSurfacePoints != null && deslocatedPointVectorSurfacePoints != null &&
            pointVectorSurfacePoints.length > 0 && deslocatedPointVectorSurfacePoints.length > 0) {
            for (Edge e : estruturaDeDadosDaSuperficie.edges) {
                drawLine(e.vertex1.vertex, e.vertex2.vertex, getRandomColor());
            }    
        }
        else
            taConsole.append(String.format("\nNão foi possível desenhar as arestas.\nDesenhe primeiro a superfície."));
    }//GEN-LAST:event_btDrawEdgesMouseClicked

    @SuppressWarnings("static-access")
    private void btDrawVertexesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDrawVertexesMouseClicked
        disableEnablePointingButton();
        if (pointVectorSurfacePoints != null && deslocatedPointVectorSurfacePoints != null &&
            pointVectorSurfacePoints.length > 0 && deslocatedPointVectorSurfacePoints.length > 0) {
            for (Vertex v : estruturaDeDadosDaSuperficie.vertexes)
                paintPoint(v.vertex);
        }
        else
            taConsole.append(String.format("\nNão foi possível desenhar os vértices.\nDesenhe primeiro a superfície."));
    }//GEN-LAST:event_btDrawVertexesMouseClicked

    @SuppressWarnings("static-access")
    private void btDrawFacesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDrawFacesMouseClicked
        disableEnablePointingButton();
        if (pointVectorSurfacePoints != null && deslocatedPointVectorSurfacePoints != null &&
            pointVectorSurfacePoints.length > 0 && deslocatedPointVectorSurfacePoints.length > 0) {
            for (Face f : estruturaDeDadosDaSuperficie.faces) {
                Color c = getRandomColor();
                drawLine(f.edge1.vertex1.vertex, f.edge1.vertex2.vertex, c);
                drawLine(f.edge2.vertex1.vertex, f.edge2.vertex2.vertex, c);
                drawLine(f.edge3.vertex1.vertex, f.edge3.vertex2.vertex, c);
            }    
        }
        else
            taConsole.append(String.format("\nNão foi possível desenhar as faces.\nDesenhe primeiro a superfície."));
    }//GEN-LAST:event_btDrawFacesMouseClicked
// </editor-fold>
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc="SETTING CODE">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurvaBSplineQuadratica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CurvaBSplineQuadratica instancia = new CurvaBSplineQuadratica();
                instancia.initiate();
            }
        });
    }

// <editor-fold defaultstate="collapsed" desc="DECLARAÇÃO DE VARIÁVEIS JAVA SWING">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClearAllSavedPointLists;
    private javax.swing.JButton btClearConsole;
    private javax.swing.JButton btClearPointArray;
    private javax.swing.JButton btClearScreen;
    private javax.swing.JButton btClearScreen2;
    private javax.swing.JButton btConnectPoints;
    private javax.swing.JButton btDataStructure;
    private javax.swing.JButton btDataStructure2;
    private javax.swing.JButton btDeletePointList;
    private javax.swing.JButton btDrawBSpline;
    private javax.swing.JButton btDrawBiggestDistance;
    private javax.swing.JButton btDrawEdges;
    private javax.swing.JButton btDrawFaces;
    private javax.swing.JButton btDrawVertexes;
    private javax.swing.JButton btEditPoints;
    private javax.swing.JToggleButton btEnablePointing;
    private javax.swing.JButton btLight;
    private javax.swing.JButton btLight2;
    private javax.swing.JButton btLoadFileList;
    private javax.swing.JButton btPaintPoints;
    private javax.swing.JButton btPrintPoints;
    private javax.swing.JButton btSaveFileList;
    private javax.swing.JButton btSavePointList;
    private javax.swing.JButton btScreenLimit;
    private javax.swing.JButton btSelectPointList;
    private javax.swing.JButton btSurface;
    private javax.swing.JButton btSurface2;
    private javax.swing.JButton btTest1;
    private javax.swing.JButton btTest2;
    private javax.swing.JButton btTest3;
    private javax.swing.JButton btTest4;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbSavedListPoints;
    private javax.swing.JLabel lbScreenLimitX;
    private javax.swing.JLabel lbScreenMaxX;
    private javax.swing.JLabel lbScreenMaxY;
    private javax.swing.JLabel lbScreenMinX;
    private javax.swing.JLabel lbScreenMinY;
    private javax.swing.JList lsSavedPointLists;
    private javax.swing.JPanel pnBSpline;
    private javax.swing.JPanel pnFunctions;
    private javax.swing.JPanel pnPoints;
    private java.awt.Panel pnScreen;
    private javax.swing.JPanel pnScreenConfig;
    private javax.swing.JPanel pnSurface;
    private javax.swing.JPanel pnTests;
    private javax.swing.JScrollPane spConsole;
    private javax.swing.JScrollPane spSavedPointLists;
    private javax.swing.JTextArea taConsole;
    private javax.swing.JTextField tfScreenLimitX;
    private javax.swing.JTextField tfScreenLimitY;
    private javax.swing.JTabbedPane tpOptionsPanel;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
}