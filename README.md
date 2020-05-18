# springboot-apiapp-azure
Springboot App - This Connects to SQL Server Database and deploys on Azure as an API APP.
# Pre requisites : Eclipse, Azure Subscription, Azure CLI, Maven Installed in your System.

1. Import the Project as an "Existing Maven Project" in Eclipse.
  - This uses pom.xml configuration.
  <groupId>com.microsoft.azure</groupId>  
        <artifactId>azure-webapp-maven-plugin</artifactId>  
        <version>1.7.0</version>  
        <configuration>
          <schemaVersion>V2</schemaVersion>
          <resourceGroup>YOUR RESOURCE GROUP</resourceGroup>
          <appName>YOUR APP NAME</appName>
          <appServicePlanResourceGroup>APP SERVICE PLAN RESOURCE GROUP</appServicePlanResourceGroup>
          <appServicePlanName>APP SERVICE PLAN NAME</appServicePlanName>
          <pricingTier>F1</pricingTier>
          <region>eastus</region>
          <runtime>
            	<os>windows</os>
                <javaVersion>1.8</javaVersion>
                <webContainer>tomcat 9.0</webContainer>
          </runtime>

2. Changes required to Connect to your Database:
\src\main\resources\application.Properties - Specify the SQL Connection Properties for SQL Server.
spring.mmand datasource.url=
spring.datasource.username=
spring.datasource.password=

3. Open Command Prompt

4. Browse to Project Path: 
  > cd Project_Path
  
5. Build the Maven Project 
  > mvn clean install -DskipTests
  
6. Download Azure Cli
  > az login

7. Deploy the Built Maven Project to Azure API APP.
  If the API - APP Exists in Azure -pom.xml has <appName>YOUR APP NAME GOES HERE</appName>
  > mvn azure-webapp:deploy




