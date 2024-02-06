def cleanDocker(String name = ''){
    if (name != ''){
        sh("docker rmi \$(docker images | grep ${name} | awk '{print\$3}') || true")
    }
}

def call(String name = ''){
    sh 'docker container prune -f'
    sh 'docker image prune --force --filter "until=360h"'
    sh 'docker builder prune --force --filter "until=360h"'
    cleanDocker(name)
}
