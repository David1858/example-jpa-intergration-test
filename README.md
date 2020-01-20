# Example JPA Integration Test

## Purpose
This example project demonstrates implementing integration tests for JPA 2.2 (with EclipseLink implementation).  The integration tests are executed outside of a container.

## Notes
* Assumption is that the source/main/resources/META-INF/persistence.xml is configured to use the server.xml (a container based project).
* This approach works for testing JPA in a JEE project because the EntityManager properties are specified outside of the persistence.xml.
* Using a source/test/resources/META-INF/persistence.xml is not an option because Maven uses the persistence.xml in the source/main/resources folder.
* This is the approach EclipseLink advocates in their documentation under "Testing JPA Outside a Container".

## Issues
* Updating the <artifactId>derby</artifactId> dependency from <version>10.14.2.0</version> to <version>10.15.1.3</version> caused issues...

## References
* https://www.eclipse.org/eclipselink/documentation/2.7/solutions/testingjpa.htm
