job('DigitalOcean-job-DSL-GITHUB') {
  description('Job DSL DigitalOcean')
  scm {
    git('https://github.com/Duvis07/jenkins.job.parametrizado.git', 'main') { node ->
      node / gitConfigName('Duvis07')
      node / gitConfigEmail('duvan.botero@est.iudigital.edu.co')
    }
  }
  parameters {
    stringParam('nombre', defaultValue = 'Duvan', description = 'Parametro de cadena para el Job Booleano')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    booleanParam('agente', false)
  }
  triggers {
    cron('H/7 * * * *')
    githubPush()
  }
  steps {
    shell("bash jobscript.sh")
  }
}
