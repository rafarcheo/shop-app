// define function
def buildApp() {
    echo "executing groovy external script!!"
}

def parametersApp() {
    echo "param string: ${params.VERSION_STRING}"
    echo "param boolean: ${params.VERSION_BOOLEAN}"
    echo "param choice: ${params.VERSION_CHOICE}"
}

// required to be able import this in jenkins file
return this

