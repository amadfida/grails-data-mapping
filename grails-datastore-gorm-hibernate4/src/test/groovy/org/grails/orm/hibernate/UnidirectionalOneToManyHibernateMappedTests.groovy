package org.grails.orm.hibernate

import grails.core.DefaultGrailsApplication
import org.grails.orm.hibernate.cfg.GrailsAnnotationConfiguration

 /**
 * @author Graeme Rocher
 * @since 1.0
 */
class UnidirectionalOneToManyHibernateMappedTests extends GroovyTestCase {

    void testAnnotatedOneToManyDomain() {
        def config = new GrailsAnnotationConfiguration()
        def gcl = new GroovyClassLoader()
        // a grails entity
        gcl.parseClass '''
class UnidirectionalOneToManyHibernateMapped {
    Long id
    Long version
}
'''

        DefaultGrailsApplication application = new DefaultGrailsApplication(gcl.loadedClasses, gcl)
        application.initialise()
        config.grailsApplication = application

        config.addAnnotatedClass OneEntity
        config.addAnnotatedClass ManyEntity
        config.buildMappings()
    }
}
