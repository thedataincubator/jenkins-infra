def cleanDocker(String name = ''){
    if (name != ''){
        sh("docker rmi \$(docker images | grep ${name} | awk '{print\$3}') || true")
    }
}

def call(String name = ''){
    sh 'docker container prune -f'
    sh 'docker image prune -f'
    cleanDocker(name)
}
