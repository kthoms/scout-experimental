package de.kthoms.scout.rt.extension.client.ui.basic.table;

import org.eclipse.scout.commons.annotations.ConfigProperty;
import org.eclipse.scout.rt.extension.client.ui.basic.table.AbstractExtensibleTable;

/**
 * A table that supports Fixed Columns.
 * 
 * @see http://eclipse.org/rap/developers-guide/devguide.php?topic=tree-table.html&version=2.0
 * @author thoms
 * @since 04.07.2014
 */
public abstract class AbstractTableWithFixedColumns extends AbstractExtensibleTable {
	public static final String PROP_FIXED_COLUMNS = "org.eclipse.rap.rwt.fixedColumns"; // =RWT.FIXED_COLUMNS
	/**
	 * Configures how many of the visible columns should be fixed.
	 * @return A value greater than 0
	 */
	@ConfigProperty(ConfigProperty.INTEGER)
	protected int getConfiguredFixedColumns () {
		return -1;
	}
	
	public void setFixedColumns (int n) {
		propertySupport.setPropertyInt(PROP_FIXED_COLUMNS, n);
	}
	
	public int getFixedColumns () {
		return propertySupport.getPropertyInt(PROP_FIXED_COLUMNS);
	}

	@Override
	protected void initConfig() {
		super.initConfig();
		setFixedColumns(getConfiguredFixedColumns());
	}
	
}
