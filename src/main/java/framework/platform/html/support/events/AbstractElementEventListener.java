package framework.platform.html.support.events;

/**
 * Use this class as base class, if you want to implement a {@link ElementEventListener} and are
 * only interested in some events. All methods provided by this class have an empty method body.
 */
public abstract class AbstractElementEventListener implements ElementEventListener {

	@Override
	public void beforeClick(Clickable target, Object... expected) {
		//NOSONAR
	}

	@Override
	public void afterClick(Clickable target, Object... expected) {
		//NOSONAR
	}

	@Override
	public void beforeType(Typeable target, String value) {
		//NOSONAR
	}

	@Override
	public void afterType(Typeable target, String value) {
		//NOSONAR
	}

	@Override
	public void beforeCheck(Checkable target, String expected) {
		//NOSONAR
	}

	@Override
	public void afterCheck(Checkable target, String expected) {
		//NOSONAR
	}

	@Override
	public void beforeCheck(Checkable target) {
		//NOSONAR
	}

	@Override
	public void afterCheck(Checkable target) {
		//NOSONAR
	}

	@Override
	public void beforeUncheck(Uncheckable target, String expected) {
		//NOSONAR
	}

	@Override
	public void afterUncheck(Uncheckable target, String expected) {
		//NOSONAR
	}

	@Override
	public void beforeUncheck(Uncheckable target) {
		//NOSONAR
	}

	@Override
	public void afterUncheck(Uncheckable target) {
		//NOSONAR
	}

	@Override
	public void beforeSubmit(Submitable target) {
		//NOSONAR
	}

	@Override
	public void afterSubmit(Submitable target) {
		//NOSONAR
	}

	@Override
	public void beforeSelect(Selectable target, int index) {
		//NOSONAR
	}

	@Override
	public void afterSelect(Selectable target, int index) {
		//NOSONAR
	}

	@Override
	public void beforeSelect(Selectable target, String value) {
		//NOSONAR
	}

	@Override
	public void afterSelect(Selectable target, String value) {
		//NOSONAR
	}

	@Override
	public void beforeDeselect(Deselectable target, int index) {
		//NOSONAR
	}

	@Override
	public void afterDeselect(Deselectable target, int index) {
		//NOSONAR
	}

	@Override
	public void beforeDeselect(Deselectable target, String value) {
		//NOSONAR
	}

	@Override
	public void afterDeselect(Deselectable target, String value) {
		//NOSONAR
	}

	@Override
	public void beforeDeselect(Deselectable target) {
		//NOSONAR
	}

	@Override
	public void afterDeselect(Deselectable target) {
		//NOSONAR
	}

	@Override
	public void beforeHover(Hoverable target, Object... expected) {
		//NOSONAR
	}

	@Override
	public void afterHover(Hoverable target, Object... expected) {
		//NOSONAR
	}
}
