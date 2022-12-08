Vagrant.require_version ">= 2.2.19"

Vagrant.configure("2") do |config|
	
	config.vagrant.plugins = "vagrant-disksize"
	
	# Машина с Docker контейнерами
	config.vm.define "docker" do |docker|
		docker.vm.box = "debian/bullseye64"
		docker.vm.box_version = "11.20211018.1"
		docker.disksize.size = "40GB"
		
		docker.vm.provider "virtualbox" do |virtualbox|
			virtualbox.memory = "2048"
			virtualbox.customize ["setextradata", :id, "VBoxInternal2/SharedFoldersEnableSymlinksCreate/v-root", "1"]
		end
	
		docker.vm.network "private_network", ip: "192.168.56.4"
		
		docker.vm.provision "ansible_local" do |ansible|
			ansible.install = true
			ansible.playbook = "./provision/docker/playbook.yml"
		end
	end
	
 
end







