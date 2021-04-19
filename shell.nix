{ pkgs ? import <nixpkgs> {} }:

with pkgs;

mkShell {
  buildInputs = [
    jdk
    jetbrains.idea-ultimate
    gradle
    docker-compose
    dbeaver
    nodejs
    nodePackages.npm
  ];
}
