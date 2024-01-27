Vagrant.require_version ">= 2.2.19"

Vagrant.configure("2") do |config|
	
	# Машина с minikube
	config.vm.define "minikube" do |minikube|
		minikube.vm.box = "debian/bookworm64"
		minikube.vm.box_version = "12.20231009.1"
		minikube.vm.disk :disk, size: "20GB", primary: true
		
		minikube.vm.provider "virtualbox" do |virtualbox|
			virtualbox.memory = "3000"
		end
	
		minikube.vm.network "private_network", ip: "192.168.56.4"
		minikube.vm.provision "ansible_local" do |ansible|
			ansible.install = true
			ansible.playbook = "./provision/playbook.yml"
		end
	end
	
 
end







