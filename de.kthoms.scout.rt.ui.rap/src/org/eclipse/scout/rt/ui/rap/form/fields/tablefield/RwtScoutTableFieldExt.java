/**
 *
 * @author thoms
 * @since 04.07.2014
 */
package org.eclipse.scout.rt.ui.rap.form.fields.tablefield;

import org.eclipse.scout.rt.client.ui.form.fields.smartfield.IContentAssistFieldProposalForm;
import org.eclipse.scout.rt.ui.rap.basic.table.IRwtScoutTable;
import org.eclipse.scout.rt.ui.rap.basic.table.RwtScoutTable;
import org.eclipse.scout.rt.ui.rap.basic.table.RwtScoutTableExt;
import org.eclipse.scout.rt.ui.rap.util.RwtUtility;

public class RwtScoutTableFieldExt extends RwtScoutTableField {
	@Override
	protected IRwtScoutTable createRwtScoutTable() {
		if (getScoutObject().getForm() instanceof IContentAssistFieldProposalForm) {
			return new RwtScoutTable(RwtUtility.VARIANT_PROPOSAL_FORM);
		} else {
			return new RwtScoutTableExt();
		}
	}

}
