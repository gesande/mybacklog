my-backlog - java api for backlogging

import eclipse formatting settings from ./buildSrc/eclipse/formatting/settings.xml

some eclipse plugins you might consider useful (not required for developing chalkbox):

eclipse-groovy plugin
  http://dist.springsource.org/release/GRECLIPSE/e3.7/

eclipse-gradle plugin
  http://kaczanowscy.pl/tomek/2010-03/gradle-ide-integration-eclipse-plugin

when developing:

install subversion
install groovy
install gradle with sources
checkout the code

build your eclipse settings:
gradle eclipseSettings

after that just import the projects to eclipse

