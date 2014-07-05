package eu.musesproject.server.rt2ae.client.scaffold.ioc;

import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import com.google.gwt.inject.client.Ginjector;

public interface ScaffoldInjector extends Ginjector {

	ScaffoldApp getScaffoldApp();
}
