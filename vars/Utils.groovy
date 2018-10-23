Boolean isMasterBranch() {
    return env.JOB_NAME.split().last() == "master"
}
