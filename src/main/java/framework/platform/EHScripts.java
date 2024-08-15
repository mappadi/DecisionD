package framework.platform;

/**
 *
 */
public enum EHScripts {
	COMSCORE_SCRIPT("EH.Settings.comscore = {\n" +
			"\" +\n" +
			"\t\t\t\"                c1: '2',\\n\" +\n" +
			"\t\t\t\"                c2: '6035818',\\n\" +\n" +
			"\t\t\t\"                c3: '',\\n\" +\n" +
			"\t\t\t\"                c4: EH.Settings.location.host + EH.Settings.location.pathname,\\n\" +\n" +
			"\t\t\t\"                c5: '',\\n\" +\n" +
			"\t\t\t\"                c6: '',\\n\" +\n" +
			"\t\t\t\"                c15: ''\\n\" +\n" +
			"\t\t\t\"            };"),
	COMSCORE_SCRIPT_URL("http://b.scorecardresearch.com/beacon.js"),
	COMSCORE_SCRIPT_URL_HTTPS("https://sb.scorecardresearch.com/beacon.js"),
	CLICKTALE_SCRIPT("<script>\n" +
			"\" +\n" +
			"\t\t\t\"        (function (d, t) {\\n\" +\n" +
			"\t\t\t\"            var g = d.createElement(t),\\n\" +\n" +
			"\t\t\t\"\\t\\t\\t\\ts = d.getElementsByTagName(t)[0];\\n\" +\n" +
			"\t\t\t\"            //g.src = '//cdn.clicktale.net/www12/ptc/4c721896-8cf9-4e13-b220-fec60517e2aa.js';\\n\" +\n" +
			"\t\t\t\"            g.src = (document.location.protocol == 'https:' ? 'https://clicktalecdn.sslcs.cdngc.net' : 'http://cdn.clicktale.net') + '/www12/ptc/4c721896-8cf9-4e13-b220-fec60517e2aa.js'\\n\" +\n" +
			"\t\t\t\"            g.async = true;\\n\" +\n" +
			"\t\t\t\"            s.parentNode.insertBefore(g, s);\\n\" +\n" +
			"\t\t\t\"        } (document, 'script'));\\n\" +\n" +
			"\t\t\t\"    </script>\n"),
	CLICKTALE_SCRIPT_URL("http://cdn.clicktale.net/www12/ptc/4c721896-8cf9-4e13-b220-fec60517e2aa.js"),
	CLICKTALE_SCRIPT_URL_HTTPS("https://clicktalecdn.sslcs.cdngc.net/www12/ptc/4c721896-8cf9-4e13-b220-fec60517e2aa.js"),
	QUALTRICS_SCRIPT("<!--BEGIN QUALTRICS SITE INTERCEPT--><script type=\"text/javascript\">(function(){var g=function(e,h,f,g){this.get=function(a){for(var a=a+\"=\",c=document.cookie.split(\";\"),b=0,e=c.length;b&lt;e;b++){for(var d=c[b];\" \"==d.charAt(0);)d=d.substring(1,d.length);if(0==d.indexOf(a))return d.substring(a.length,d.length)}return null};this.set=function(a,c){var b=\"\",b=new Date;b.setTime(b.getTime()+6048E5);b=\"; expires=\"+b.toGMTString();document.cookie=a+\"=\"+c+b+\"; path=/; \"};this.check=function(){var a=this.get(f);if(a)a=a.split(\":\");else if(100!=e)\"v\"==h&amp;&amp;(e=Math.random()&gt;=e/100?0:100),a=[h,e,0],this.set(f,a.join(\":\"));else return!0;var c=a[1];if(100==c)return!0;switch(a[0]){case \"v\":return!1;case \"r\":return c=a[2]%Math.floor(100/c),a[2]++,this.set(f,a.join(\":\")),!c}return!0};this.go=function(){if(this.check()){var a=document.createElement(\"script\");a.type=\"text/javascript\";a.src=g+ \"&amp;t=\" + (new Date()).getTime();document.body&amp;&amp;document.body.appendChild(a)}};this.start=function(){var a=this;window.addEventListener?window.addEventListener(\"load\",function(){a.go()},!1):window.attachEvent&amp;&amp;window.attachEvent(\"onload\",function(){a.go()})}};try{(new g(100,\"r\",\"QSI_S_ZN_brP7urzDaJ4Xmxn\",\"//zn_brp7urzdaj4xmxn-edhealth.siteintercept.qualtrics.com/WRSiteInterceptEngine/?Q_ZID=ZN_brP7urzDaJ4Xmxn&amp;Q_LOC=\"+encodeURIComponent(window.location.href))).start()}catch(i){}})();</script><div id=\"ZN_brP7urzDaJ4Xmxn\"><!--DO NOT REMOVE-CONTENTS PLACED HERE--></div><!--END SITE INTERCEPT-->"),
	QUALTRICS_SCRIPT_URL("http://zn_brp7urzdaj4xmxn-edhealth.siteintercept.qualtrics.com/WRSiteInterceptEngine/?Q_ZID=ZN_brP7urzDaJ4Xmxn&Q_LOC="),
	QUALTRICS_SCRIPT_URL_HTTPS("https://zn_brp7urzdaj4xmxn-edhealth.siteintercept.qualtrics.com/WRSiteInterceptEngine/?Q_ZID=ZN_brP7urzDaJ4Xmxn&Q_LOC="),
	OPTIMIZELY_SCRIPT("<script src=\"//cdn.optimizely.com/js/275071578.js\"></script> <script> window.optimizely = window.optimizely || []; window.optimizely.push(\"activateSiteCatalyst\");</script>"),
	INDEX_EXCHANGE_SCRIPT("<script>\n" +
			"        // Index Exchange is not active on CuSo Edit Package.\n" +
			"        // Synchronously load Index Exchange, then FAST.\n" +
			"\t\tif(!loadAdScripts.isCuso) {\n" +
			"\t\t\twindow.googletag = window.googletag || {};\n" +
			"\t\t\twindow.googletag.cmd = window.googletag.cmd || [];\n" +
			"\n" +
			"\t\t\tloadAdScripts.load('http://js.indexww.com/ht/everydayhealth.js', 'index-exchange', function () {\n" +
			"\t\t\t\t'use strict';\n" +
			"\t\t\t\tloadAdScripts.initFAST();\n" +
			"\t\t\t});\n" +
			"\t\t}\n"),
	INDEX_EXCHANGE_SCRIPT_URL("http://js.indexww.com/ht/everydayhealth.js"),
	GTM_SCRIPT("(function (w, d, s, l, i) {\n" +
			"                    w[l] = w[l] || []; w[l].push({\n" +
			"                        'gtm.start':\n" +
			"                        new Date().getTime(), event: 'gtm.js'\n" +
			"                    }); var f = d.getElementsByTagName(s)[0],\n" +
			"                    j = d.createElement(s), dl = l != 'dataLayer' ? '&amp;l=' + l : ''; j.async = true; j.src =\n" +
			"                    'https://www.googletagmanager.com/gtm.js?id='"),
	GTM_SCRIPT_MINIFIED("<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],j=d.createElement(s),dl=l!='dataLayer'?'&amp;l='+l:'';j.async=true;j.src='https://www.googletagmanager.com/gtm.js?id='"),
	GTM_SCRIPT_URL("https://www.googletagmanager.com/gtm.js?id=GTM-MLL5DL"),
	GOOGLE_ANALYTICS_STRING("UA-30535-1"),
	GOOGLE_ANALYTICS_URL("https://www.google-analytics.com/analytics.js"),
	BOUNCE_EXCHANGE_SCRIPT("<script>(function(d){var e=d.createElement('script');e.src=d.location.protocol+'//tag.bounceexchange.com/2293/i.js';e.async=true;d.getElementsByTagName(\"head\")[0].appendChild(e);}(document));</script>");


	private String script;

	EHScripts(String script) {
		this.script = script;
	}

	public String getText() {
		return script;
	}
}
