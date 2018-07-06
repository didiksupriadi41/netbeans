/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */

package org.netbeans.modules.web.struts.dialogs;

import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.text.JTextComponent;
import org.netbeans.modules.web.api.webmodule.WebModule;
import org.netbeans.modules.web.struts.StrutsConfigDataObject;
import org.netbeans.modules.web.struts.StrutsConfigUtilities;
import org.netbeans.modules.web.struts.config.model.Action;
import org.openide.util.NbBundle;

/**
 *
 * @author  radko
 */
public class AddForwardDialogPanel extends javax.swing.JPanel implements ValidatingPanel {
    StrutsConfigDataObject config;
    /** Creates new form AddForwardDialog */
    public AddForwardDialogPanel(StrutsConfigDataObject config, String targetActionPath) {
        this.config=config;
        initComponents();
        List actions = StrutsConfigUtilities.getAllActionsInModule(config);
        DefaultComboBoxModel model = (DefaultComboBoxModel)jComboBoxFwdAction.getModel();
        DefaultComboBoxModel model1 = (DefaultComboBoxModel)jComboBoxLocationAction.getModel();
        Iterator iter = actions.iterator();
        while (iter.hasNext()) {
            String actionPath=((Action)iter.next()).getAttributeValue("path"); //NOI18N
            model.addElement(actionPath);
            model1.addElement(actionPath);
        }
        if (targetActionPath != null) {
            jRadioButtonLocationAction.setSelected(true);
            jComboBoxLocationAction.setSelectedItem(targetActionPath);
        }
    }
    public AddForwardDialogPanel(StrutsConfigDataObject config) {
        this(config,null);
    }

    public String validatePanel() {
        if (getForwardName().length()==0)
            return NbBundle.getMessage(AddActionPanel.class,"MSG_EmptyForwardName");
        if (jRadioButtonResFile.isSelected()) {
            String resourceFile = jTextFieldResFile.getText().trim();
            if (resourceFile.length()==0 || resourceFile.equals("/")) //NOI18N
                return NbBundle.getMessage(AddActionPanel.class,"MSG_EmptyResourceFile");
        } else if (jComboBoxFwdAction.getSelectedItem()==null) {
            return NbBundle.getMessage(AddActionPanel.class,"MSG_EmptyAction");
        }
        if (jRadioButtonLocationAction.isSelected() && jComboBoxLocationAction.getSelectedItem()==null) {
            return NbBundle.getMessage(AddActionPanel.class,"MSG_EmptyAction");
        }
        return null;
    }

    public AbstractButton[] getStateChangeComponents() {
        return new AbstractButton[] {jRadioButtonResFile, jRadioButtonGlobal};
    }

    public JTextComponent[] getDocumentChangeComponents() {
        return new JTextComponent[]{jTextFieldFwdName, jTextFieldResFile};
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabelFwdName = new javax.swing.JLabel();
        jTextFieldFwdName = new javax.swing.JTextField();
        jLabelFwdTo = new javax.swing.JLabel();
        jRadioButtonResFile = new javax.swing.JRadioButton();
        jTextFieldResFile = new javax.swing.JTextField();
        jButtonBrowse = new javax.swing.JButton();
        jRadioButtonFwdAction = new javax.swing.JRadioButton();
        jComboBoxFwdAction = new javax.swing.JComboBox();
        jCheckBoxRedirect = new javax.swing.JCheckBox();
        jLabelLocation = new javax.swing.JLabel();
        jRadioButtonGlobal = new javax.swing.JRadioButton();
        jRadioButtonLocationAction = new javax.swing.JRadioButton();
        jComboBoxLocationAction = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 11, 11));
        setLayout(new java.awt.GridBagLayout());

        jLabelFwdName.setDisplayedMnemonic(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "MNE_AddFwdDialog_FwdName").charAt(0));
        jLabelFwdName.setLabelFor(jTextFieldFwdName);
        jLabelFwdName.setText(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "LBL_AddFwdDialog_ForwardName")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 12);
        add(jLabelFwdName, gridBagConstraints);

        jTextFieldFwdName.setColumns(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(jTextFieldFwdName, gridBagConstraints);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/netbeans/modules/web/struts/dialogs/Bundle"); // NOI18N
        jTextFieldFwdName.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_jTextFieldFwdName")); // NOI18N

        jLabelFwdTo.setText(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "LBL_AddFwdDialog_ForwardTo")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(jLabelFwdTo, gridBagConstraints);

        buttonGroup1.add(jRadioButtonResFile);
        jRadioButtonResFile.setMnemonic(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "MNE_AddFwdDialog_ResFile").charAt(0));
        jRadioButtonResFile.setSelected(true);
        jRadioButtonResFile.setText(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "RB_ResourceFile")); // NOI18N
        jRadioButtonResFile.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonResFile.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonResFileItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 5, 12);
        add(jRadioButtonResFile, gridBagConstraints);
        jRadioButtonResFile.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_jRadioButtonResFile_Forward")); // NOI18N

        jTextFieldResFile.setColumns(30);
        jTextFieldResFile.setText("/");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(jTextFieldResFile, gridBagConstraints);
        jTextFieldResFile.getAccessibleContext().setAccessibleName(bundle.getString("ACSN_jTextFieldResFile")); // NOI18N
        jTextFieldResFile.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_jTextFieldResFile_F")); // NOI18N

        jButtonBrowse.setMnemonic(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "MNE_AddFwdDialog_Browse").charAt(0));
        jButtonBrowse.setText(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "LBL_BrowseButton")); // NOI18N
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 5, 0);
        add(jButtonBrowse, gridBagConstraints);
        jButtonBrowse.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_jButtonBrowse")); // NOI18N

        buttonGroup1.add(jRadioButtonFwdAction);
        jRadioButtonFwdAction.setMnemonic(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "MNE_AddFwdDialog_FwdAction").charAt(0));
        jRadioButtonFwdAction.setText(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "RB_Action")); // NOI18N
        jRadioButtonFwdAction.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 12, 12);
        add(jRadioButtonFwdAction, gridBagConstraints);
        jRadioButtonFwdAction.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_jRadioButtonFwdAction")); // NOI18N

        jComboBoxFwdAction.setEditable(true);
        jComboBoxFwdAction.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        add(jComboBoxFwdAction, gridBagConstraints);
        jComboBoxFwdAction.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_jComboBoxFwdAction")); // NOI18N

        jCheckBoxRedirect.setMnemonic(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "MNE_AddFwdDialog_Redirect").charAt(0));
        jCheckBoxRedirect.setText(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "LBL_AddFwdDialog_Redirect")); // NOI18N
        jCheckBoxRedirect.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        add(jCheckBoxRedirect, gridBagConstraints);
        jCheckBoxRedirect.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_jCheckBoxRedirect")); // NOI18N

        jLabelLocation.setText(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "LBL_AddFwdDialog_Location")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(jLabelLocation, gridBagConstraints);

        buttonGroup2.add(jRadioButtonGlobal);
        jRadioButtonGlobal.setMnemonic(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "MNE_AddFwdDialog_Global").charAt(0));
        jRadioButtonGlobal.setSelected(true);
        jRadioButtonGlobal.setText(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "LBL_AddFwdDialog_Global")); // NOI18N
        jRadioButtonGlobal.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonGlobal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonGlobalItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 5, 0);
        add(jRadioButtonGlobal, gridBagConstraints);
        jRadioButtonGlobal.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_jRadioButtonGlobal")); // NOI18N

        buttonGroup2.add(jRadioButtonLocationAction);
        jRadioButtonLocationAction.setMnemonic(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "MNE_AddFwdDialog_LocationAction").charAt(0));
        jRadioButtonLocationAction.setText(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "RB_Action")); // NOI18N
        jRadioButtonLocationAction.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        add(jRadioButtonLocationAction, gridBagConstraints);
        jRadioButtonLocationAction.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_jRadioButtonLocationAction")); // NOI18N

        jComboBoxLocationAction.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jComboBoxLocationAction, gridBagConstraints);
        jComboBoxLocationAction.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(AddForwardDialogPanel.class, "ACSN_FAction")); // NOI18N
        jComboBoxLocationAction.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_jComboBoxLocationAction")); // NOI18N

        getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_AddForwardDialog")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonGlobalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonGlobalItemStateChanged
// TODO add your handling code here:
        jComboBoxLocationAction.setEnabled(!jRadioButtonGlobal.isSelected());
    }//GEN-LAST:event_jRadioButtonGlobalItemStateChanged

    private void jRadioButtonResFileItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonResFileItemStateChanged
// TODO add your handling code here:
        boolean selected = jRadioButtonResFile.isSelected();
        jTextFieldResFile.setEditable(selected);
        jButtonBrowse.setEnabled(selected);
        jComboBoxFwdAction.setEnabled(!selected);
    }//GEN-LAST:event_jRadioButtonResFileItemStateChanged

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
// TODO add your handling code here:
        try{
        org.netbeans.api.project.SourceGroup[] groups = StrutsConfigUtilities.getDocBaseGroups(config.getPrimaryFile());
            org.openide.filesystems.FileObject fo = BrowseFolders.showDialog(groups);
            if (fo!=null) {
                String res = "/"+StrutsConfigUtilities.getResourcePath(groups,fo,'/',true);
                jTextFieldResFile.setText(res);
            }
        } catch (java.io.IOException ex) {}
    }//GEN-LAST:event_jButtonBrowseActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JCheckBox jCheckBoxRedirect;
    private javax.swing.JComboBox jComboBoxFwdAction;
    private javax.swing.JComboBox jComboBoxLocationAction;
    private javax.swing.JLabel jLabelFwdName;
    private javax.swing.JLabel jLabelFwdTo;
    private javax.swing.JLabel jLabelLocation;
    private javax.swing.JRadioButton jRadioButtonFwdAction;
    private javax.swing.JRadioButton jRadioButtonGlobal;
    private javax.swing.JRadioButton jRadioButtonLocationAction;
    private javax.swing.JRadioButton jRadioButtonResFile;
    private javax.swing.JTextField jTextFieldFwdName;
    private javax.swing.JTextField jTextFieldResFile;
    // End of variables declaration//GEN-END:variables
    
    public String getForwardName() {
        return jTextFieldFwdName.getText().trim();
    }
    
    public boolean isGlobal() {
        return jRadioButtonGlobal.isSelected();
    }
    
    public String getRedirect() {
        return (jCheckBoxRedirect.isSelected()?"true":null);
    }
    
    public String getForwardTo() {
        if (jRadioButtonResFile.isSelected()) {
            return jTextFieldResFile.getText().trim();
        } else {
            return StrutsConfigUtilities.getActionAsResource(
                    WebModule.getWebModule(config.getPrimaryFile()),
                    (String)jComboBoxFwdAction.getSelectedItem());
        }
    }

    public String getLocationAction() {
        return (String)jComboBoxLocationAction.getSelectedItem();
    }
}