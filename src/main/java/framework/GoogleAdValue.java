package framework;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * GoogleAdValue
 */
public enum GoogleAdValue {

	PAGE("page"),
	CT("ct"),
	CAT("cat"),
	SPEC("spec"),
	UNIT_ID("Unit Id"),
	CORRELATOR("Correlator"),
	POS("pos"),
	SIZE("Size"),
	SLOT("slot"),
	UGC("ugc"),
	PLT("plt"),
	ADOBEID("AdobeID"),
	P("p"),
	C("c"),
	Z("z"),
	TA("ta"),
	TG("tg"),
	NL("nl"),
	U("u"),
	BTG("btg"),
	MDV("mdv"),
	MA("ma"),
	INVIEW("inview"),
	PROF("prof"),
	BCSRC("bcsrc"),
	PAGEVIEWID("pageviewid");

	private static final List<GoogleAdValue> VALUES =
			Collections.unmodifiableList(Arrays.asList(values()));

	private String googleAd;

	GoogleAdValue(String googleAd) {
		this.googleAd = googleAd;
	}

	public String getGoogleAdString() {
		return googleAd;
	}

}
