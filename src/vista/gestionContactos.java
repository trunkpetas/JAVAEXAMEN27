package vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Contacto;

public class gestionContactos extends javax.swing.JFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    ArrayList<Character> todasLasLetras = new ArrayList();

    /*Cambiar*/
    ArrayList<Contacto> contactos;

    Estados e;
    int contactoExacto;
    Contacto c;

    public gestionContactos() {

        initComponents();

        //btnCargaryGuardar.setEnabled(false);
        contactos = new ArrayList();

        sdf.setLenient(false);

        contactoExacto = 0;

//        Contacto c0 = new Contacto("58003683Y", "Manolo", "Martinez", "Louro", 666333222, new Date(13, 2, 1989), "Amigo");
//        Contacto c1 = new Contacto("47388736L", "Pepe", "Paradise", "TuPutaMadre", 987654321, new Date(16, 9, 1991), "Familia");
//        Contacto c2 = new Contacto("93299259N", "Jesus", "Jones", "Perez", 777444999, new Date(11, 5, 2011), "Trabajo");
//        Contacto c3 = new Contacto("87990407C", "Lelo", "Fernandez", "Louro", 357753357, new Date(11, 7, 1999), "Familia");
//
//        contactos.add(c0);
//        contactos.add(c1);
//        contactos.add(c2);
//        contactos.add(c3);
        //System.out.println(c1);
        if (contactos.isEmpty()) {

            e = Estados.AÑADIENDO; 

            JOptionPane.showMessageDialog(null, "A CONTINUACION SE INICIA LA AGENDA EN EL ESTADO AÑADIR PORQUE NO HAY NINGÚN CONTACTO, DONDE PODRÁS CARGAR DATOS DE FICHERO SI QUIERES", "AÑADIR", JOptionPane.INFORMATION_MESSAGE);

        } else {
            e = Estados.NAVEGANDO;
        }
        estadoSeleccionado(e);

    }

    private void añadiendo() {
        //btnCargaryGuardar.setEnabled(true);
        //cargarDatosbtn.setEnabled(true);
        if (contactos.isEmpty()) {
            guardarDatoas.setEnabled(false);
            cargarDatosbtn.setEnabled(true);
            btnCancelar.setEnabled(false);
        } else {
            guardarDatoas.setEnabled(true);
            cargarDatosbtn.setEnabled(false);
            btnCancelar.setEnabled(true);
        }
        jComboBox1.setEnabled(true);
        btnAceptar.setEnabled(true);
        //btnCancelar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnPrimero.setEnabled(false);
        btnAñadir.setEnabled(false);

        txtNif.setEditable(true);
        txtNombre.setEditable(true);
        txtApellido1.setEditable(true);
        txtApellido2.setEditable(true);
        txtTelefono.setEditable(true);
        txtNacimiento.setEditable(true);
        //txtTipo.setEditable(true);

        //contactos.add(new Contacto(txtNif.getText(), txtNombre.getText(), txtApellido1.getText(),
        //txtApellido2.getText(), Long.parseLong(txtTelefono.getText()), sdf.parse(txtNacimiento.getText()), txtTipo.getText()));
        txtNif.setText("");
        txtNombre.setText("");
        txtApellido1.setText("");
        txtApellido2.setText("");
        txtTelefono.setText("");
        //txtTipo.setText("");
        txtNacimiento.setText("");

//        if (txtNif.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido1.getText().isEmpty()
//                || txtApellido2.getText().isEmpty() || txtNacimiento.getText().isEmpty()) {
//
//            btnCancelar.setEnabled(false);
//
//        }else{
//                    
//        }
    }

    /*
    private void metiendoDatosBro() {

        txtNif.setText(lblNif.getText());
        txtNombre.setText(lblNombre.getText());
        txtApellido1.setText(lblApellido1.getText());
        txtApellido2.setText(lblApellido2.getText());
        txtTelefono.setText(String.valueOf(lblTelefono.getText()));
        txtNacimiento.setText(sdf.format(lblNacimiento.getText()));
        txtTipo.setText(lblTipo.getText());

    }
     */
    private void borrando() {
        //btnCargaryGuardar.setEnabled(false);
        // System.out.println("e");
//        borrarContactosDeLaLista();
        //cargarDatosbtn.setEnabled(false);
        //guardarDatosbtn.setEnabled(false);

        jComboBox1.setEnabled(false);
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnPrimero.setEnabled(false);
        btnAñadir.setEnabled(false);

    }

    private void editando() {
        //btnCargaryGuardar.setEnabled(false);
        //cargarDatosbtn.setEnabled(false);
//        guardarDatosbtn.setEnabled(false);
        jComboBox1.setEnabled(true);
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnPrimero.setEnabled(false);
        btnAñadir.setEnabled(false);

        txtNombre.setEditable(true);
        txtApellido1.setEditable(true);
        txtApellido2.setEditable(true);
        txtTelefono.setEditable(true);
        txtNacimiento.setEditable(true);
        //txtTipo.setEditable(true);
    }

    private void muestraLetras() {

        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        for (int i = 0; i < letras.length; i++) {

            todasLasLetras.add(letras[i]);

        }
    }

    private boolean compruebaDni() {
        muestraLetras();
        String dni = txtNif.getText();

        //Scanner key = new Scanner(System.in);
        int numerosDni = 0;
        try {
            if (dni.length() != 9) {
                //System.out.println("ugcdsFREFSDFQ");
                JOptionPane.showMessageDialog(null, "Longitud errónea", "DNI", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            if (!Character.isLetter(dni.toUpperCase().charAt(8))) {
                //System.out.println("ugcdsFREFSDFQ");
                JOptionPane.showMessageDialog(null, "Falta la letra", "DNI", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            if (!todasLasLetras.contains(dni.toUpperCase().charAt(8))) {
                //System.out.println("ugcdsFREFSDFQ");
                JOptionPane.showMessageDialog(null, "Letra errónea", "DNI", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            //System.out.println("tuputamader\n");
            //System.out.println("Introduce un dni: ");
//            if (numerosDni != Integer.parseInt(dni.substring(0, 8))) {
//
//                JOptionPane.showMessageDialog(null, "DNI ERRONEO", "DNI", JOptionPane.INFORMATION_MESSAGE);
//                return false;
//            }
            for (int i = 0; i < dni.length() - 1; i++) {

                if (!Character.isDigit(dni.charAt(i))) {

                    JOptionPane.showMessageDialog(null, "Dni erróneo", "DNI", JOptionPane.INFORMATION_MESSAGE);
                    return false;

                }

            }
            numerosDni = Integer.parseInt(dni.substring(0, 8));
            System.out.println(numerosDni);
            int calculoLetra = numerosDni % 23;
            System.out.println(calculoLetra);

            if (!todasLasLetras.get(calculoLetra).equals(dni.charAt(8))) {
                JOptionPane.showMessageDialog(null, "Dni Incorrecto", "DNI", JOptionPane.INFORMATION_MESSAGE);

                return false;
            }

            System.out.println(todasLasLetras.get(calculoLetra));
        } catch (IndexOutOfBoundsException index) {

            JOptionPane.showMessageDialog(null, "A TU DNI LE FALTA ALGO", "DNI", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    private void navegando() {

        guardarDatoas.setEnabled(true);
        cargarDatosbtn.setEnabled(false);

//btnCargaryGuardar.setEnabled(true);
        //guardarDatosbtn.setEnabled(false);
        //cargarDatosbtn.setEnabled(false);
        //cargarDatosbtn.setEnabled(false);
        //guardarDatoas.setEnabled(false);
        jComboBox1.setEnabled(false);

        //System.out.println(andando);
        //velarBtn();
        txtNif.setEditable(false);
        //sdf.setLenient(false);
        if (contactos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Puede elegir entre crear los datos o cargarlos de un archivo", "Añadir/Cargar", JOptionPane.INFORMATION_MESSAGE);

            e = Estados.AÑADIENDO;
            estadoSeleccionado(e);

        } else {

            txtNif.setText(contactos.get(0).getNif());
            txtNombre.setText(contactos.get(0).getNombre());
            txtApellido1.setText(contactos.get(0).getApellido1());
            txtApellido2.setText(contactos.get(0).getApellido2());
            txtTelefono.setText(String.valueOf(contactos.get(0).getTelefono()));
            txtNacimiento.setText(sdf.format(contactos.get(0).getNacimiento()));
            jComboBox1.setSelectedItem(contactos.get(0).getTipo());

            //contactos.get(0).getTipo(jComboBox1.getSelectedItem().toString()) // txtNif.setEditable(false);
            txtNombre.setEditable(false);
            txtApellido1.setEditable(false);
            txtApellido2.setEditable(false);
            txtTelefono.setEditable(false);
            txtNacimiento.setEditable(false);
            //txtTipo.setEditable(false);

            btnAceptar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnEditar.setEnabled(true);
            btnBorrar.setEnabled(true);
            btnAnterior.setEnabled(true);
            btnUltimo.setEnabled(true);
            btnSiguiente.setEnabled(true);
            btnPrimero.setEnabled(true);
            btnAñadir.setEnabled(true);
        }
    }

    public enum Estados {
        NAVEGANDO,
        AÑADIENDO,
        EDITANDO,
        BORRANDO
//        CARGANDOYGUARDANDO
    }

    public void estadoSeleccionado(Estados e) {

        switch (e) {
            case AÑADIENDO:
                añadiendo();
                break;
            case BORRANDO:
                borrando();
                break;
            case EDITANDO:
                editando();
                break;
            case NAVEGANDO:
                navegando();
                break;
//            case CARGANDOYGUARDANDO:
//                cargandoyguardando();
//                break;
        }

    }

//    private void cargandoyguardando() {
//
//        cargaDatos();
//        guardaDatos();
//
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnAñadir = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        cargarDatosbtn = new javax.swing.JButton();
        guardarDatoas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNif = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNacimiento = new javax.swing.JTextField();
        lblNif = new javax.swing.JLabel();
        lblApellido1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido2 = new javax.swing.JLabel();
        lblNacimiento = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAñadir.setText("Añadir o Cargar");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        cargarDatosbtn.setText("CargarDatos");
        cargarDatosbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatosbtnActionPerformed(evt);
            }
        });

        guardarDatoas.setText("guardarDatos");
        guardarDatoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarDatoasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargarDatosbtn)
                    .addComponent(guardarDatoas)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnAñadir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(91, 91, 91))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnAñadir)
                .addGap(22, 22, 22)
                .addComponent(btnBorrar)
                .addGap(32, 32, 32)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addGap(35, 35, 35)
                .addComponent(btnCancelar)
                .addGap(28, 28, 28)
                .addComponent(cargarDatosbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(guardarDatoas)
                .addGap(27, 27, 27))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtNif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNifActionPerformed(evt);
            }
        });

        txtTelefono.setMaximumSize(new java.awt.Dimension(999999999, 999999999));

        txtNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNacimientoActionPerformed(evt);
            }
        });

        lblNif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNif.setText("NIF");
        lblNif.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNif.setEnabled(false);

        lblApellido1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellido1.setText("Primer Apellido");
        lblApellido1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblApellido1.setEnabled(false);

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");
        lblNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNombre.setEnabled(false);

        lblApellido2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellido2.setText("Segundo Apellido");
        lblApellido2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblApellido2.setEnabled(false);

        lblNacimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNacimiento.setText("Nacimiento(\"dd-MM-yyyy\")");
        lblNacimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNacimiento.setEnabled(false);

        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTelefono.setText("Telefono");
        lblTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTelefono.setEnabled(false);

        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo.setText("Tipo");
        lblTipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTipo.setEnabled(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amigo", "Enemigo", "Trabajo", "Familia" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipo)
                    .addComponent(lblNacimiento)
                    .addComponent(lblTelefono)
                    .addComponent(lblApellido2)
                    .addComponent(lblApellido1)
                    .addComponent(lblNombre)
                    .addComponent(lblNif, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre)
                    .addComponent(txtNif, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(txtApellido1)
                    .addComponent(txtApellido2)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNacimiento)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtApellido1, txtApellido2, txtNacimiento, txtNif, txtNombre, txtTelefono});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblApellido1, lblApellido2, lblNacimiento, lblNif, lblNombre, lblTelefono, lblTipo});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNif, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNif, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido2))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNacimiento))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtApellido1, txtApellido2, txtNacimiento, txtNif, txtNombre, txtTelefono});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblApellido1, lblApellido2, lblNacimiento, lblNif, lblNombre, lblTelefono, lblTipo});

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnPrimero.setText("|<<");
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });

        btnAnterior.setText("<--");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setText("-->");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnUltimo.setText(">>|");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimero)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente)
                    .addComponent(btnUltimo))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        cargarDatosbtn.setEnabled(true);
        guardarDatoas.setEnabled(true);

        JOptionPane.showMessageDialog(null, "Puede, o añadir a mano o cargar los datos", "Datos", JOptionPane.INFORMATION_MESSAGE);

        e = Estados.AÑADIENDO;
        estadoSeleccionado(e);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        if (contactos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Puede añadir a continuacion", "Estado Añadir", JOptionPane.ERROR_MESSAGE);

            e = Estados.AÑADIENDO;
            estadoSeleccionado(e);
        } else {
            navegando();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void añadirConcactosALaLista() {

        // boolean saliendo = false;
        //sdf.setLenient(false);
        //Contacto contactoC 
        if (txtNif.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido1.getText().isEmpty() || txtApellido2.getText().isEmpty()
                || txtTelefono.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtNacimiento.getText().isEmpty()) {

            //btnCancelar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "TE HA FALTADO UN CAMPO POR COMPLETAR", "CAMPOS VACÍOS", JOptionPane.ERROR_MESSAGE);

        } else {
            try {
                if (parseFecha() && compruebaDni()) {

                    contactos.add(new Contacto(txtNif.getText(), txtNombre.getText(), txtApellido1.getText(),
                            txtApellido2.getText(), Integer.parseInt(txtTelefono.getText()), sdf.parse(txtNacimiento.getText()), jComboBox1.getSelectedItem().toString()));

                    e = Estados.NAVEGANDO;
                    estadoSeleccionado(e);
                } else {
                    //JOptionPane.showMessageDialog(null, "Has introducido una fehca erróneo", "Atención", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null, "Has introducido un telefono erróneo", "Atención", JOptionPane.ERROR_MESSAGE);

            } catch (ParseException pex) {
                JOptionPane.showMessageDialog(null, "Has introducido una fecha errónea", "Atención", JOptionPane.ERROR_MESSAGE);

            }

        }
    }

    private boolean parseFecha() {

        Date date;

        try {
            date = sdf.parse(txtNacimiento.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Has introducido una fehca erróneo", "Atención", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        int año = date.getYear();
        Date añoActual = new Date();
        if (año > añoActual.getYear()) {
            return false;
        }
        return true;
    }

    private void borrarContactosDeLaLista() {

        //System.out.println("e");
        if (contactos.isEmpty()) {
            añadiendo();
        } else {
            contactos.remove(contactoExacto);

        }
        contactoExacto = 0;
        e = Estados.NAVEGANDO;
        estadoSeleccionado(e);
    }

    private void editarContactosDeLaLista() {
        txtNif.setEditable(false);

        //compruebaDni();
        //sdf.setLenient(false);
        c = contactos.get(contactoExacto);

        try {
            if (parseFecha()) {
                c.setNombre(txtNombre.getText());
                c.setApellido1(txtApellido1.getText());
                c.setApellido2(txtApellido2.getText());
                c.setTelefono(Integer.parseInt(txtTelefono.getText()));
                c.setNacimiento(sdf.parse(txtNacimiento.getText()));
                c.setTipo(jComboBox1.getSelectedItem().toString());
                e = Estados.NAVEGANDO;
                estadoSeleccionado(e);
            } else {
                //JOptionPane.showMessageDialog(null, "Has introducido una fehca errónea", "Atención", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "Has introducido un telefono erróneo", "Atención", JOptionPane.ERROR_MESSAGE);

        } catch (ParseException pex) {

            JOptionPane.showMessageDialog(null, "Has introducido una fecha errónea", "Atención", JOptionPane.ERROR_MESSAGE);

        }

        contactos.set(contactoExacto, c);

    }

//            txtNif.setText(c.getNif());
//            txtNombre.setText(contactos.get(andando).getNombre());
//            txtApellido1.setText(contactos.get(andando).getApellido1());
//            txtApellido2.setText(contactos.get(andando).getApellido2());
//            txtTelefono.setText(String.valueOf(contactos.get(andando).getTelefono()));
//            txtNacimiento.setText(sdf.format(contactos.get(andando).getNacimiento()));
//            txtTipo.setText(contactos.get(andando).getTipo());
//        
//    private void cambiaEstado() {
// 
//    }

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        switch (e) {
            case AÑADIENDO: {

                try {
                    //System.out.println("llega al primer aañdur");
                    //compruebaDni();
                    añadirConcactosALaLista();

                    //System.out.println("llega al primer aañdur");
                } catch (NumberFormatException ex) {
                    // System.out.println("llega al primer carcg");
                    JOptionPane.showMessageDialog(null, "Has introducido un telefono erróneo", "Atención", JOptionPane.ERROR_MESSAGE);

//                } catch (ParseException pex) {
//
//                    JOptionPane.showMessageDialog(null, "Has introducido una fehca erróneo", "Atención", JOptionPane.ERROR_MESSAGE);
//                    System.out.println("llega al segundo");
                    //parseFecha();
                }
            }
            break;

            case BORRANDO:
                //System.out.println("e");
                if (contactos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Has pasado al modo AÑADIR",
                            "AÑADIR", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    borrarContactosDeLaLista();

                }
                break;
            case EDITANDO: {
                try {
                    editarContactosDeLaLista();
                    // } catch (ParseException ex) {

                    //JOptionPane.showMessageDialog(null, "Has introducido una fecha errónea", "Atención", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(null, "Has introducido un telefono erróneo", "Atención", JOptionPane.ERROR_MESSAGE);

                }
            }
            break;
            case NAVEGANDO:
                navegando();
                break;
        }

//        if (e == Estados.AÑADIENDO) {
//            
//            try {
//                añadirConcactosALaLista();
//            } catch (ParseException ex) {
//                Logger.getLogger(gestionContactos.class.getName()).log(Level.SEVERE, null, ex);
//            }
//           
//        } else if (e.equals(Estados.BORRANDO)) {
//            System.out.println("e");
//            borrarContactosDeLaLista();
//        }
//        estadoSeleccionado(e);
//        borrarContactosDeLaLista();
//        añadirConcactosALaLista();
        //navegando();

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNacimientoActionPerformed

    }//GEN-LAST:event_txtNacimientoActionPerformed
    private void rellenaDatos(int valor) {
        //sdf.setLenient(false);
        txtNif.setText(contactos.get(valor).getNif());
        txtNombre.setText(contactos.get(valor).getNombre());
        txtApellido1.setText(contactos.get(valor).getApellido1());
        txtApellido2.setText(contactos.get(valor).getApellido2());
        txtTelefono.setText(String.valueOf(contactos.get(valor).getTelefono()));
        txtNacimiento.setText(sdf.format(contactos.get(valor).getNacimiento()));
        jComboBox1.setSelectedItem(contactos.get(valor).getTipo());

    }
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        //System.out.println(andando);

        if (contactoExacto < contactos.size() - 1) {
            contactoExacto++;
            rellenaDatos(contactoExacto);
        }
        // navegando();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        //System.out.println(andando);
        if (contactoExacto > 0) {
            contactoExacto--;
            rellenaDatos(contactoExacto);
        }
        //navegando();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        //velarBtn();
        //sdf.setLenient(false);
        txtNif.setText(contactos.get(contactos.size() - 1).getNif());
        txtNombre.setText(contactos.get(contactos.size() - 1).getNombre());
        txtApellido1.setText(contactos.get(contactos.size() - 1).getApellido1());
        txtApellido2.setText(contactos.get(contactos.size() - 1).getApellido2());
        txtTelefono.setText(String.valueOf(contactos.get(contactos.size() - 1).getTelefono()));
        txtNacimiento.setText(sdf.format(contactos.get(contactos.size() - 1).getNacimiento()));
        jComboBox1.setSelectedItem((contactos.get(contactos.size() - 1).getTipo()));
        contactoExacto = contactos.size() - 1;
//            contactos.get(contactos.size() - 1);
        //navegando();
    }//GEN-LAST:event_btnUltimoActionPerformed
    /*
    private void velarBtn() {

        if (andando == 0) {
            btnAnterior.setEnabled(false);
            btnPrimero.setEnabled(false);

        } else if (andando == contactos.size() - 1) {
            btnAnterior.setEnabled(true);
            btnPrimero.setEnabled(true);
            btnUltimo.setEnabled(false);
            btnSiguiente.setEnabled(false);
        } else if (andando == 0 && andando == contactos.size() - 1) {

            btnPrimero.setEnabled(false);
            btnAnterior.setEnabled(false);
            btnSiguiente.setEnabled(false);
            btnUltimo.setEnabled(false);

        }

    }
     */
    private void guardaDatos() {

        try {
            File file = new File("agenda");
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(null);
            file = fc.getSelectedFile();
            try (ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(file, true))) {
                guardar.writeObject(contactos);
            }
        } catch (FileNotFoundException f) {

            f.getMessage();

        } catch (IOException ex) {
            ex.getMessage();
        } catch (NullPointerException nl) {
            JOptionPane.showMessageDialog(null, "Error al guardar el fichero", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargaDatos() {

//        btnAnterior.setEnabled(true);
//        btnPrimero.setEnabled(true);
//        btnUltimo.setEnabled(true);
//        btnUltimo.setEnabled(true);
        File file = new File("agenda");
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        file = fc.getSelectedFile();

        try (ObjectInputStream cargar = new ObjectInputStream(new FileInputStream(file))) {
            try {
                contactos = (ArrayList<Contacto>) cargar.readObject();
                e = Estados.NAVEGANDO;
                estadoSeleccionado(e);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(gestionContactos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException f) {

            f.getMessage();

        } catch (IOException ex) {
            ex.getMessage();
        } catch (NullPointerException n2) {
            JOptionPane.showMessageDialog(null, "Error al cargar el fichero", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        //velarBtn();
        //sdf.setLenient(false);
        txtNif.setText(contactos.get(0).getNif());
        txtNombre.setText(contactos.get(0).getNombre());
        txtApellido1.setText(contactos.get(0).getApellido1());
        txtApellido2.setText(contactos.get(0).getApellido2());
        txtTelefono.setText(String.valueOf(contactos.get(0).getTelefono()));
        txtNacimiento.setText(sdf.format(contactos.get(0).getNacimiento()));
        jComboBox1.setSelectedItem(contactos.get(0).getTipo());
        //txtTipo.setText(contactos.get(0).getTipo());
        contactoExacto = 0;
        // navegando();
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        e = Estados.BORRANDO;
        borrando();

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        e = Estados.EDITANDO;
        editando();

    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtNifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNifActionPerformed
        compruebaDni();
        //validarDni();
    }//GEN-LAST:event_txtNifActionPerformed

    private void cargarDatosbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDatosbtnActionPerformed
        cargaDatos();
    }//GEN-LAST:event_cargarDatosbtnActionPerformed

    private void guardarDatoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarDatoasActionPerformed

        guardaDatos();

    }//GEN-LAST:event_guardarDatoasActionPerformed
    /**//**/
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gestionContactos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestionContactos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestionContactos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestionContactos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gestionContactos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JButton cargarDatosbtn;
    private javax.swing.JButton guardarDatoas;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblNacimiento;
    private javax.swing.JLabel lblNif;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtNacimiento;
    private javax.swing.JTextField txtNif;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
