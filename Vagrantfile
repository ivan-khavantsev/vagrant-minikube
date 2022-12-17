Vagrant.require_version ">= 2.2.19"

Vagrant.configure("2") do |config|
	
	config.vagrant.plugins = ["vagrant-disksize"]
	
	# Машина с minikube
	config.vm.define "minikube" do |minikube|
		minikube.vm.box = "debian/bullseye64"
		minikube.vm.box_version = "11.20211018.1"
		minikube.disksize.size = "40GB"
		
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







