Boolean isMasterBranch() {
    return env.JOB_NAME.split("/").last() == "master"
}

String cronString(String c) {
    if (isMasterBranch()) {
        return 'c'
    } else {
        return ''
    }
}

void sendJenkins(boolean success) {
    //only send if on master
    if (isMasterBranch()){
        if (success){
            // don't send if not previously bad
            if (currentBuild.getPreviousBuild().result != 'SUCCESS'){
                slackSend(color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} is back to success ${env.BUILD_URL}")
            }
        } else { //send if not success
            slackSend(color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was not successful, ${env.BUILD_URL}")
        }
    }
}

Boolean isBranchTriggered() {
    return (currentBuild.rawBuild.getCauses()[0].getClass() == jenkins.branch.BranchEventCause)
}
