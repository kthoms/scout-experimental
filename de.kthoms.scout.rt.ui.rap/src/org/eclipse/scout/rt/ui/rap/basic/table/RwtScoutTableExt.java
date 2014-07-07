/**
 *
 * @author thoms
 * @since 04.07.2014
 */
package org.eclipse.scout.rt.ui.rap.basic.table;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.scout.rt.client.ui.basic.table.columns.IColumn;
import org.eclipse.scout.rt.ui.rap.ext.table.TableEx;
import org.eclipse.swt.widgets.Composite;

public class RwtScoutTableExt extends RwtScoutTable {
	@Override
	protected void initializeUi(Composite parent) {
		super.initializeUi(parent);
	    TableEx table = getUiField();
		// Fixed Columns Support
		// see
		// http://eclipse.org/rap/developers-guide/devguide.php?topic=tree-table.html&version=2.0
		// the configured fixed columns refer to visible columns only, but for
		// the RWT table the number of fixed
		// columns include also the non-visible ones. Compute how many columns
		// should be fixed in the RWT table.
		Integer configuredFixedColumns = (Integer) getScoutObject().getProperty(
				RWT.FIXED_COLUMNS);
		if (configuredFixedColumns != null && configuredFixedColumns > 0) {
			int fixedColumns = 0;
			int visibleColumns = 0;
			for (IColumn<?> column : getScoutObject().getColumns()) {
				fixedColumns++;
				if (column.isDisplayable() && column.isInitialVisible()) {
					visibleColumns++;
				}
				if (visibleColumns == configuredFixedColumns) {
					break;
				}
			}
			table.setData(RWT.FIXED_COLUMNS, new Integer(fixedColumns));
		}
	}

}
