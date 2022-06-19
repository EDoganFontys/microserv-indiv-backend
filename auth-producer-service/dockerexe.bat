@echo

echo Building docker image
docker build -t auth-producer:latest .

echo Logging in to the azure container registry
docker login emreregistry.azurecr.io

echo Taging the docker image with the prefix of the azure container registry to be able to push it to the azure container registry.
docker tag auth-producer emreregistry.azurecr.io/auth-producer

echo Finally, pushing it to the registry.
docker push emreregistry.azurecr.io/auth-producer

pause
