#!/bin/sh

TOMCAT_SERVER_URL=$1
echo "Tomcat Serrver Url is : $TOMCAT_SERVER_URL"

VERSION_NO=$2
echo "Version to be downloaded is : $VERSION_NO"

TOMCAT_ADMIN=$3
echo "Tomcat Admin user id is : $TOMCAT_ADMIN_PASSWD"

TOMCAT_ADMIN_PASSWD=$4

cd /tmp

echo "Downloading autoclaim war version $VERSION_NO"
wget "http://ec2-52-52-237-5.us-west-1.compute.amazonaws.com:8091/nexus/content/repositories/releases/com/example/autoclaim/$VERSION_NO/autoclaim-$VERSION_NO.war"

if [ -f autoclaim-$VERSION_NO.war ]; then
        echo "Downloaded autoclaim war version $VERSION_NO from ec2-52-52-237-5.us-west-1.compute.amazonaws.com:8091"

        cp autoclaim-$VERSION_NO.war autoclaim.war
        echo "Copied autoclaim-$VERSION_NO.war to autoclaim.war"

        echo "Undeploy previous version of autoclaim on Tomcat Server $TOMCAT_SERVER_URL"
        curl -v --basic --user $TOMCAT_ADMIN:$TOMCAT_ADMIN_PASSWD "http://manager-script:changeit@$TOMCAT_SERVER_URL/manager/text/undeploy?path=/autoclaim&update=true"
        echo "Undeploy autoclaim on Tomcat Server $TOMCAT_SERVER_URL is successful"
        
        echo "Deploying autoclaim.war to Tomcat Server $TOMCAT_SERVER_URL"
        curl -v --basic --user $TOMCAT_ADMIN:$TOMCAT_ADMIN_PASSWD --upload-file autoclaim.war "http://manager-script:changeit@$TOMCAT_SERVER_URL/manager/text/deploy?path=/autoclaim&update=true"
        echo "Deployment of autoclaim app binaries version $VERSION_NO on server $TOMCAT_SERVER_URL is Successful"
        
        rm -f autoclaim*.war
        echo "Downloaded binaries deleted from tmp folder"
else
        echo "Deployment of autoclaim app binaries version $VERSION_NO on server $TOMCAT_SERVER_URL Failed"
fi
